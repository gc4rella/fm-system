/*
 * Copyright (c) 2016 Open Baton (http://www.openbaton.org)
 *
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

package org.openbaton.faultmanagement.repo;

import org.openbaton.faultmanagement.catalogue.ManagedNetworkServiceRecord;
import org.openbaton.faultmanagement.catalogue.ThresholdHostnames;

/** Created by mob on 28/06/16. */
public interface ManagedNetworkServiceRecordRepositoryCustom {
  ManagedNetworkServiceRecord addPmJobId(String nsrId, String vduId, String pmJobId);

  ManagedNetworkServiceRecord addThresholdHostnames(
      String nsrId, String thresholdId, ThresholdHostnames thresholdHostnames);

  ManagedNetworkServiceRecord addFmPolicyId(String nsrId, String thresholdId, String fmPolicyId);

  ManagedNetworkServiceRecord addVnfTriggerId(String nsrId, String thresholdId);

  String addUnsubscriptionId(String nsrId, String unSubscriptionId);
}
