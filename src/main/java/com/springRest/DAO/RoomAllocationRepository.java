package com.springRest.DAO;

import com.springRest.enitity.RoomAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomAllocationRepository extends JpaRepository<RoomAllocation, Integer> {
}
