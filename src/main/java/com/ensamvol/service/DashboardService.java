package com.ensamvol.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface DashboardService {
    public double totalRevenue();
    public double totalBillet();
    public Integer totalFlights();
    public Integer totalClients();
}
