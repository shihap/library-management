package com.library.library_management;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // يمكنك إضافة طرق مخصصة هنا إذا كنت بحاجة لعمل استعلامات خاصة
    List<Book> findByTitle(String title);
}
