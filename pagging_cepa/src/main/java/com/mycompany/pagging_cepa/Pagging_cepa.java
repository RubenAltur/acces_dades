/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */package com.mycompany.pagging_cepa;
 import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;


/**
 *
 * @author ruben
 */
public class Pagging_cepa {

    private static final int TAMAÑO_PAGINA = 12;
    private static int paginaActual = 1;

    public static void main(String[] args) {
        try (Session factory = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Scanner scanner = new Scanner(System.in);

            mostrarEmpleados(factory, paginaActual);

            while (true) {
                System.out.println("Ingrese una letra: (S) Siguiente, (A) Anterior, (G n) Ir a la página n, (Q) Salir");
                String input = scanner.nextLine().toUpperCase();
                mostrarEmpleados(factory, paginaActual);

                switch (input) {
                    case "S":
                        paginaActual++;
                        break;
                    case "A":
                        if (paginaActual > 1) {
                            paginaActual--;
                        }
                        break;
                    case "Q":
                        System.out.println("Saliendo del programa...");
                        return;
                    default:
                        if (input.startsWith("G ")) {
                            try {
                                int pagina = Integer.parseInt(input.substring(2));
                                if (pagina >= 1) {
                                    paginaActual = pagina;
                                } else {
                                    System.out.println("Número de página inválido.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Formato de entrada inválido.");
                            }
                        } else {
                            System.out.println("Entrada inválida.");
                        }
                        break;
                }
                mostrarEmpleados(factory, paginaActual);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mostrarEmpleados(Session factory, int pagina) {
        try  {
            factory.beginTransaction();

            Query<employees> query = factory.createQuery("from employees", employees.class);
            query.setFirstResult((pagina - 1) * TAMAÑO_PAGINA);
            query.setMaxResults(TAMAÑO_PAGINA);
            List<employees> empleados = query.getResultList();

            System.out.println("Página " + pagina + " de " + calcularTotalPaginas(factory) + " - Empleados:");
            for (employees empleado : empleados) {
                System.out.println(empleado);
            }

            factory.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int calcularTotalPaginas(Session session) {
        Query<Long> countQuery = session.createQuery("select count(*) from employees", Long.class);
        long totalRegistros = countQuery.uniqueResult();
        return (int) Math.ceil((double) totalRegistros / TAMAÑO_PAGINA);
    }
   
}