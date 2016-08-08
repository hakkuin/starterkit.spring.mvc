package pl.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.constants.ViewNames;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

/**
 * Book controller
 * 
 * @author mmotowid
 *
 */
@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;  

	private static final String WELCOME = "Book search section";
	private static final String INFO_TEXT = "Here You shall display wtf";
	
	@RequestMapping
	public String list(Model model) {
		model.addAttribute(ModelConstants.GREETING, WELCOME);
		model.addAttribute(ModelConstants.INFO, INFO_TEXT);
		return ViewNames.BOOKS;
	}

	/**
	 * Method collects info about all books
	 */
	@RequestMapping("/all")
	public ModelAndView allBooks() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(ModelConstants.GREETING, WELCOME).setViewName(ViewNames.BOOKS);
		modelAndView.addObject(ModelConstants.BOOK_LIST, bookService.findAllBooks());
		return modelAndView;
	}

	/**
	 * Method collects info about all books
	 */
	@RequestMapping("/search")
	public ModelAndView searchBooks() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(ModelConstants.GREETING, WELCOME).setViewName(ViewNames.BOOKS);
		modelAndView.addObject(ModelConstants.BOOK_LIST, bookService.findAllBooks());
		return modelAndView;
	}

	/**
	 * Method collects info about books searched by author
	 */
	@RequestMapping("/by-authors")
	public ModelAndView booksByAuthors(@RequestParam String authors) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(ModelConstants.GREETING, WELCOME).setViewName(ViewNames.BOOKS);
		modelAndView.addObject(ModelConstants.BOOK_LIST, bookService.findBooksByAuthor(authors));
		return modelAndView;
	}

	/**
	 * Method collects info about books searched by title
	 */
	@RequestMapping("/by-title")
	public ModelAndView booksByTitle(@RequestParam String title) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(ModelConstants.GREETING, WELCOME).setViewName(ViewNames.BOOKS);
		modelAndView.addObject(ModelConstants.BOOK_LIST, bookService.findBooksByTitle(title));
		return modelAndView;
	}
	
	/**
	 * Method collects info about books searched by both title and authors
	 */
	@RequestMapping("/by-title-and-authors")
	public ModelAndView booksByTitle(@RequestParam String title, @RequestParam String authors) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(ModelConstants.GREETING, WELCOME).setViewName(ViewNames.BOOKS);
		modelAndView.addObject(ModelConstants.BOOK_LIST, bookService.findBooksByAuthorAndTitle(authors, title));
		return modelAndView;
	}
	
	/**
	 * Method collects info about books searched by both title and authors
	 */
	@RequestMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(ModelConstants.BOOK, bookService.findBookById(id));
		bookService.deleteBook(id);
		modelAndView.setViewName(ViewNames.DELETE);
		return modelAndView;
	}
	
	/**
	 * Method collects info about books searched by both title and authors
	 */
	@RequestMapping("/book")
	public ModelAndView bookDetails(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(ModelConstants.BOOK, bookService.findBookById(id));
		modelAndView.setViewName(ViewNames.BOOK);
		return modelAndView;
	}

	/**
	 * Method allows to add new book to the store db
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute(ModelConstants.NEW_BOOK, new BookTo());
		return ViewNames.ADD_BOOK;
	}
	
	/**
	 * Method collects info about newly added book
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	// TODO: Ask about this weird shit
	public ModelAndView addSubmit(@ModelAttribute("newBook") BookTo newBook, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		if (newBook.getTitle().isEmpty() || newBook.getAuthors().isEmpty()) {
			modelAndView.setViewName(ViewNames.ADD_BOOK_FAILURE);
			return modelAndView;
		}
		newBook = bookService.saveBook(newBook);
		modelAndView.addObject(newBook);
		modelAndView.setViewName(ViewNames.RESULT);
		model.addAttribute(ModelConstants.NEW_BOOK, newBook);
		return modelAndView;
	}
	
	/**
	 * Binder initialization
	 */
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("id", "title", "authors", "status");
	}

}
