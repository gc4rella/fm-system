/*
 * Copyright (c) 2015 Fraunhofer FOKUS
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openbaton.catalogue.mano.common.faultmanagement;

import javax.persistence.Entity;
import java.util.Iterator;

/**
 * Created by mob on 29.10.15.
 */
@Entity
public class VNFFaultManagementPolicy extends FaultManagementPolicy {
    private FaultManagementVNFCAction action;

    public VNFFaultManagementPolicy(){

    }

    public FaultManagementVNFCAction getAction() {
        return action;
    }

    public void setAction(FaultManagementVNFCAction action) {
        this.action = action;
    }

    @Override
    public String toString() {
        String result= "VNFFaultManagementPolicy{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", cooldown=" + cooldown +
                ", period=" + period +
                ", severity=" + severity +
                ", criteria=";
        if(criteria !=null){
            Iterator<Criteria>criteriaIterator= criteria.iterator();
            while(criteriaIterator.hasNext())
                result+= criteriaIterator.next().toString();
        }
        else result+="null";
        result+=", action=" + action;
        return result;
    }
}
