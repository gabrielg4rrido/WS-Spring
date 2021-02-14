package com.garr.ws.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.garr.ws.entities.User;
import com.garr.ws.repositories.UserRepository;
import com.garr.ws.services.exceptions.DatabaseException;
import com.garr.ws.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User insert (User user) {
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);	
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public User update (Long id, User user) {
		try {
			User entity = userRepository.getOne(id);
			updateData(entity, user);
			return userRepository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}

	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id){
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}