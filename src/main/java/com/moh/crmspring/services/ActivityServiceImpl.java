package com.moh.crmspring.services;

import com.moh.crmspring.entities.Activity;
import com.moh.crmspring.exceptions.NotFoundException;
import com.moh.crmspring.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Activity> findAllByIds(Iterable<Long> ids) {
        return activityRepository.findAllById(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Activity> findActivitiesByParticipantId(Long id) {
        return activityRepository.findActivitiesByParticipantId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Activity findById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Activity with id " + id + " not found"));
    }

    @Override
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public void delete(Activity activity) {
        activityRepository.delete(activity);
    }
}
