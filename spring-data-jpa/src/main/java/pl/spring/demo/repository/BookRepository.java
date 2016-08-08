package pl.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.spring.demo.entity.BookEntity;

import java.util.List;

/**
 * Book repository
 * 
 * @author PPATRONI
 *
 */
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    /**
     * Finds books by title
     * 
     * @param title
     * @return
     */
    @Query("select book from BookEntity book where upper(book.title) like concat('%', upper(:title), '%')")
    public List<BookEntity> findBookByTitle(@Param("title") String title);

    /**
     * Finds books by author
     * 
     * @param author
     * @return
     */
    @Query("select book from BookEntity book where upper(book.authors) like concat('%', upper(:author), '%')")
    public List<BookEntity> findBookByAuthor(@Param("author") String author);

	/**
	 * Finds books by title and author 
	 * 
	 * @param authors
	 * @param title
	 * @return
	 */
	@Query("select book from BookEntity book where upper(book.authors)  like concat('%', upper(:authors), '%') and upper(book.title) like concat('%', upper(:title), '%')")
	public List<BookEntity> findBookByAuthorAndTitle(@Param("authors") String authors, @Param("title") String title);
}
