package com.radek.cinema;

import com.radek.cinema.hibernate.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Map.entry;

public class Database {

    private static Database instance;
    private static Session session;
    private static SessionFactory sessionFactory;

    private Database() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        sessionFactory = metadata.buildSessionFactory();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public boolean login(String username, String password) {
        try {
            session = sessionFactory.openSession();
            return Optional.ofNullable(session.createCriteria(User.class).add(Restrictions.allEq(Map.ofEntries(
                    entry("username", username),
                    entry("password", password)
            ))).uniqueResult()).isPresent();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return false;
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Movie");
            movies = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return movies;
    }

    public ObservableList<Order> getUserOrders(int userId) {
        List<Order> orders = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from Order where userId = :userId");
            orders = query.setParameter("userId", userId).list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return FXCollections.observableArrayList(orders);
    }

    public void hibernateCostam() {
        try {
            session = sessionFactory.openSession();
//
//            session.getTransaction().begin();

//            Movie movie = new Movie("Grinch", "Ósme wspólne dzieło Illumination i Universal Pictures" +
//                    " – komedia animowana „Grinch” – na podstawie świątecznego klasyka – książki „Dr. Seuss”. " +
//                    "Historia zrzędliwego, cynicznego stwora, który marzy tylko o jednym – by ukraść święta Bożego " +
//                    "Narodzenia. Zabawna, pełna ciepła, uniwersalna, oszałamiająco sfilmowana historia świąteczna z " +
//                    "olbrzymią dawką optymizmu.", 90);
//
//            movie.getDirectors().add(new Director("Yarrow", "Cheney"));
//            movie.getDirectors().add(new Director("Scott", "Mosier"));
//
//            movie.getActors().add(new Actor("Benedict", "Cumberbatch"));
//
//            movie.getGenres().add(new Genre("Animowany"));
//            movie.getGenres().add(new Genre("Komedia"));
//            movie.getGenres().add(new Genre("Familijny"));
//
//            session.save(movie);

//            Movie movie = (Movie) session.createCriteria(Movie.class)
//                    .add(Restrictions.eq("title", "First Man")).uniqueResult();
//
//            if (movie != null) {
//                System.out.println(movie.getTitle());
//                movie.getDirectors().forEach(d -> System.out.println(d.getSurname()));
//                movie.getActors().forEach(a -> System.out.println(a.getSurname()));
//                movie.getGenres().forEach(g -> System.out.println(g.getName()));
//
//            }

//            Ticket ticket = (Ticket) session.get(Ticket.class, 1);
//            System.out.println(ticket.getSeanceId());
//            System.out.println(ticket.getTicketType().getName());

            Order order = session.get(Order.class, 13);
            System.out.println(order.getId());
            System.out.println(order.getSeance().getId());
//
//            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
//            session.getTransaction().rollback();
        }
    }

    public void close() {
        if (session != null) session.close();
    }

}
