package br.com.alexcoimbra12.userregister.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alexcoimbra12.userregister.model.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String> {

	UserModel findByEmail(String email);

}
