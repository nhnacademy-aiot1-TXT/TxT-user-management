package com.user.management.repository;

import com.user.management.dto.UserDataResponse;
import com.user.management.entity.Role;
import com.user.management.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * 사용자(User) 정보를 관리하는 레포지터리 인터페이스입니다.
 *
 * @author jjunho50
 * @version 1.0.0
 */
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * 주어진 ID에 해당하는 사용자의 Role 을 조회합니다.
     *
     * @param userId 사용자 ID
     * @return 사용자 Role
     */
    @Query("SELECT u.role FROM User u WHERE u.id = :id")
    Role getRoleByUserId(@Param("id") String userId);

    /**
     * 모든 사용자 정보를 조회하여 반환합니다. (어드민 유저만 조회 가능)
     *
     * @return 사용자 페이지 객체
     */
    @Query("SELECT new com.user.management.dto.UserDataResponse(u.id, u.name, u.email, u.role.name, u.status.name, u.password, u.provider.id) FROM User u")
    Page<UserDataResponse> getAllUserData(Pageable pageable);

    /**
     * 상태가 일치하는 사용자의 정보를 조회하여 반환
     *
     * @param id status id
     * @return 사용자 페이지 객체
     */
    @Query("SELECT new com.user.management.dto.UserDataResponse(u.id, u.name, u.email, u.role.name, u.status.name, u.password, u.provider.id) FROM User u WHERE u.status.id = :id")
    Page<UserDataResponse> getUsersFilteredByStatusId(Pageable pageable, Long id);

    /**
     * 권한이 일치하는 사용자즤 정보를 조회하여 반환
     *
     * @param id 권한 아이디
     * @return 사용자 페이지 객체
     */
    @Query("SELECT new com.user.management.dto.UserDataResponse(u.id, u.name, u.email, u.role.name, u.status.name, u.password, u.provider.id) FROM User u WHERE u.role.id = :id")
    Page<UserDataResponse> getUsersFilteredByRoleId(Pageable pageable, Long id);

    /**
     * 주어진 ID에 해당하는 사용자 정보를 조회하여 반환합니다.
     *
     * @param userId 사용자 ID
     * @return Optional<UserDataResponse>
     */
    @Query("SELECT new com.user.management.dto.UserDataResponse(u.id, u.name, u.email, u.role.name, u.status.name, u.password, u.provider.id) FROM User u WHERE u.id = :id")
    Optional<UserDataResponse> getUserById(@Param("id") String userId);

    /**
     * 이메일이 일치하는 사용자를 조회하여 반환
     *
     * @param email 이메일
     * @return 사용자
     */
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> getByEmail(@Param("email") String email);
}