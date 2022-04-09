package com.lilianlima.springProject.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lilianlima.springProject.entities.User;
import com.lilianlima.springProject.repositories.UserRepository;
import com.lilianlima.springProject.services.exceptions.DatabaseException;
import com.lilianlima.springProject.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id);//o getone nao vai direto no bd ainda, prepara o obj, o findbyid vai direto no banco dados 
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) { //caso colocar um id q nao exista. Usar RunTimeException para ver qual é a excessao no console
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(User entity, User obj) {//atualiza os dados do entity baseado no q chegou do obj. Nao atualiza id nem senha
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
