/*
 * Copyright © 2013 VillageReach.  All Rights Reserved.  This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 *
 * If a copy of the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openlmis.core.builder;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.PropertyLookup;
import org.openlmis.core.domain.Facility;
import org.openlmis.core.domain.Program;
import org.openlmis.core.domain.SupervisoryNode;
import org.openlmis.core.domain.SupplyLine;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;

public class SupplyLineBuilder {
    public static final Instantiator<SupplyLine> defaultSupplyLine = new Instantiator<SupplyLine>() {
        @Override
        public SupplyLine instantiate(PropertyLookup<SupplyLine> lookup) {
            SupervisoryNode supervisoryNode = make(a(SupervisoryNodeBuilder.defaultSupervisoryNode));
            Facility facility = make(a(FacilityBuilder.defaultFacility));
            Program program = make(a(ProgramBuilder.defaultProgram));

            SupplyLine supplyLine = new SupplyLine();
            supplyLine.setSupervisoryNode(supervisoryNode);
            supplyLine.setSupplyingFacility(facility);
            supplyLine.setProgram(program);

            return supplyLine;
        }
    };
}
