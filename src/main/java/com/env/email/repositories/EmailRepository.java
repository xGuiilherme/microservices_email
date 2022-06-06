package com.env.email.repositories;

import com.env.email.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository <EmailModel, Long>{
}
