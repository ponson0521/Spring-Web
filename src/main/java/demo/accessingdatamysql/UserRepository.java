package demo.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
    // 可在此設定一些query方法以供使用
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM user u WHERE u.id=?1", nativeQuery = true)
    void deleteUserById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user u SET u.name=?1, u.sex=?2, u.email=?3, u.phone=?4 WHERE u.id=?5", nativeQuery = true)
    void updateProfileById(String name, String sex, String email, String phone, Integer id);

    @Transactional
    @Query(value = "SELECT * FROM user u WHERE u.account=?1", nativeQuery = true)
    User findUserByAccount(String account);
}