package com.boostmytool.service.suppliers;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boostmytool.model.suppliers.Supplier;

public interface SuppliersRepository extends JpaRepository<Supplier, Integer>{
    @Query("SELECT s FROM Supplier s WHERE " +
            "LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.address) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.phone) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Supplier> findByKeyword(@Param("keyword") String keyword);
    
    @Query("SELECT COUNT(s) FROM Supplier s")
    int totalNumberSupplier(); 
 
    @Query("SELECT s FROM Supplier s ORDER BY s.totalRevenue DESC")
    List<Supplier> findTop3SuppliersByRevenue(Pageable pageable);
}