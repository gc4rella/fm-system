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

import org.openbaton.catalogue.mano.common.monitoring.PerceivedSeverity;
import org.openbaton.catalogue.util.IdGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by mob on 29.10.15.
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class FaultManagementPolicy implements Serializable{
    @Id
    protected String id;
    @Version
    protected int version = 0;
    protected String name;
    protected int cooldown;
    protected int period;
    protected PerceivedSeverity severity;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    protected Set<Criteria> criteria;

    @PrePersist
    public void ensureId(){
        id= IdGenerator.createUUID();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public PerceivedSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(PerceivedSeverity severity) {
        this.severity = severity;
    }

    public Set<Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(Set<Criteria> criteria) {
        this.criteria = criteria;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "FaultManagementPolicy{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", cooldown=" + cooldown +
                ", period=" + period +
                ", severity=" + severity +
                ", criteria=" + criteria +
                '}';
    }
}
