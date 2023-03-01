package com.moh.crmspring.services;

import com.moh.crmspring.entities.Activity;

import java.util.List;

public interface ActivityService {
    List<Activity> findAll();
    Activity findById(Long id);
    Activity save(Activity activity);
    void delete(Activity activity);
}
