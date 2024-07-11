package com.devstack.FitnessTrackerServer.Repository;

import com.devstack.FitnessTrackerServer.Entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
