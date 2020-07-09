package com.syed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syed.entity.ContactEntity;

public interface ContactDtlsRepository extends JpaRepository<ContactEntity, Integer> {

}
