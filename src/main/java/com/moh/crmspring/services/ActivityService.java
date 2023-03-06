package com.moh.crmspring.services;

import com.moh.crmspring.entities.Activity;

import java.util.List;

public interface ActivityService {
    List<Activity> findAll();

    List<Activity> findAllByIds(Iterable<Long> ids);
    List<Activity> findActivitiesByParticipantId(Long id);

    Activity findById(Long id);

    Activity save(Activity activity);

    void delete(Activity activity);
}
