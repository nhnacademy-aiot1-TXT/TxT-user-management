package com.user.management.repository;

import com.user.management.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 상태(Status)에 대한 데이터를 접근하는 레포지터리입니다.
 * JpaRepository를 상속 받아 기본적인 CRUD 기능을 제공합니다.
 */
public interface StatusRepository extends JpaRepository<Status, Long> {

    /**
     * 일반 회원 상태를 찾아 반환하는 메소드입니다.
     * 일반 회원 (Long) ID = 1
     *
     * @return 일반 회원 상태. (DataLoader.class 로 인해 null 발생 위험 x)
     */
    default Status getActiveStatus() {
        return findById(1L).orElse(null);
    }

    /**
     * 휴면 회원 상태를 찾아 반환하는 메소드입니다.
     * 휴면 회원 (Long) ID = 2
     *
     * @return 휴면 회원 상태. (DataLoader.class 로 인해 null 발생 위험 x)
     */
    default Status getInActiveStatus()
    {
        return findById(2L).orElse(null);
    }

    /**
     * 탈퇴 회원 상태를 찾아 반환하는 메소드입니다.
     * 탈퇴 회원 (Long) ID = 3
     *
     * @return 탈퇴 회원 상태. (DataLoader.class 로 인해 null 발생 위험 x)
     */
    default Status getDeactivatedStatus()
    {
        return findById(3L).orElse(null);
    }
}