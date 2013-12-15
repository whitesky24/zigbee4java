/*
   Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies 
   of the Italian National Research Council 


   See the NOTICE file distributed with this work for additional 
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.bubblecloud.zigbee.model;

import com.itaca.ztool.api.ZToolAddress16;
import com.itaca.ztool.api.ZToolAddress64;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 19:00:05 +0300 (Tue, 06 Aug 2013) $)
 * @since 0.1.0
 *
 */
public interface AnnunceListner {

	/**
	 * Callback invoked when an <i>Annunce</i> message arrives
	 * 
	 * @param senderAddress	the network address of the node which sent the <i>Annunce</i> message
	 * @param ieeeAddress the 64-bit address of the node that is the subject of the 
	 * 			<i>Annunce</i> message 
	 * @param networkAddress the network address assigned to the node that is the subject 
	 * 			of the <i>Annunce</i> message
	 * @param capabilitiesBitmask the bitmask identifying the network capibility of the 
	 * 			node that is the subject of the <i>Annunce</i> message
	 */
	void notify(ZToolAddress16 senderAddress, ZToolAddress64 ieeeAddress,
                ZToolAddress16 networkAddress, int capabilitiesBitmask);

}
