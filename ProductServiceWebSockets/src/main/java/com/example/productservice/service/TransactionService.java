package com.example.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.dto.TransactionRequestDto;
import com.example.productservice.dto.TransactionResponseDto;
import com.example.productservice.dto.TransactionStatus;
import com.example.productservice.entity.UserTransaction;
import com.example.productservice.repository.UserRepository;
import com.example.productservice.repository.UserTransactionRepository;
import com.example.productservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTransactionRepository transactionRepository;
	
	public Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto requestDto){ 
		return this.userRepository.updateUserBalance(requestDto.getUserId(), requestDto.getAmount())
						.filter(Boolean::booleanValue)
						.map(b -> EntityDtoUtil.toEntity(requestDto))
						.flatMap(this.transactionRepository::save)
						.map(ut -> EntityDtoUtil.toDto(requestDto, TransactionStatus.APPROVED))
						.defaultIfEmpty(EntityDtoUtil.toDto(requestDto, TransactionStatus.DECLINED));
	}
	
	public Flux<UserTransaction> getByUserId(int userId){
		return this.transactionRepository.findByUserId(userId);
	}
}
