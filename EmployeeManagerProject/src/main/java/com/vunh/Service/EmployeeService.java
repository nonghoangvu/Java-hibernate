package com.vunh.Service;

import com.vunh.Model.Employees;
import com.vunh.Util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

@SuppressWarnings("removal")
public class EmployeeService {
    private EntityManager em = JPAUtil.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        this.em.close();
        super.finalize();
    }

    public List<Employees> getAll() {
        try {
            TypedQuery<Employees> query = em.createQuery("SELECT e FROM Employees e", Employees.class);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean insertEmployee(Employees emp) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(emp);
            this.em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            return false;
        }
    }
}
