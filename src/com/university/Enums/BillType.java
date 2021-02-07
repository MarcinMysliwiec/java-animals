package com.university.Enums;

import com.university.Utils;

public enum BillType {
    GENERALIST("Wszystkożercy"),
    INSECT_CATCHING("Owadożercy"),
    GRAIN_EATING("Ziarnożercy"),
    CONIFEROUS_SEED_EATING("Do skubania szyszek"),
    NECTAR_FEEDING("Nektaropijcy"),
    FRUIT_EATING("Owadożercy"),
    CHISELING("Do kucia w drewnie"),
    DIP_NETTING("Do przecedzania"),
    SURFACE_SKIMMING("Do zbierania z powierzchni"),
    SCYTHING("Do drążenia w błocie"),
    PROBING("Do drążenia"),
    FILTER_FEEDING("Filtracyjny"),
    AERIAL_FISHING("Do łowienia ryb z powietrza"),
    PURSUIT_FISHING("Do łowienia ryb pod wodą"),
    SCAVENGING("Padlinożercy"),
    RAPTORIAL("Drapieżnika");

    private String polishName;

    BillType(String polishNameParam) {
        polishName = polishNameParam;
    }

    @Override
    public String toString() {
        return Utils.capitalize(polishName);
    }
}