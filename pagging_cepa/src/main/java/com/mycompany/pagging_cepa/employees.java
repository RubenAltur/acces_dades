/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pagging_cepa;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author ruben
 */




// Empleado.java
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class employees implements Serializable {

    @Id
    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "birth_date")
    private Date fechaNacimiento;

    @Column(name = "first_name")
    private String primerNombre;

    @Column(name = "last_name")
    private String apellido;

    @Column(name = "gender")
    private String genero;

    @Column(name = "hire_date")
    private Date fechaContratacion;

    // getters y setters

    public employees() {
    }

    @Override
    public String toString() {
        return "empNo=" + empNo + ", fechaNacimiento=" + fechaNacimiento + ", primerNombre=" + primerNombre + ", apellido=" + apellido + ", genero=" + genero + ", fechaContratacion=" + fechaContratacion + "\n";
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
    
}