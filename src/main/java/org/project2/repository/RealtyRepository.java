package org.project2.repository;

import org.project2.Realty;
import org.project2.exceptions.RealtyAddressNotFoundException;
import org.project2.exceptions.RealtyStatusNotFoundException;
import org.project2.exceptions.RealtyStratumNotFoundException;

import java.util.List;

public interface RealtyRepository {
    List<Realty> findByAddress(String address) throws RealtyAddressNotFoundException;
    List<Realty> findByStratum(int stratum) throws RealtyStratumNotFoundException;
    List<Realty> findByRealtyStatus(String realtyStatus) throws RealtyStatusNotFoundException;
}