package com.tts.site.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.site.model.Subscriber;

public interface SiteRepository extends CrudRepository<Subscriber, Long> {

}
