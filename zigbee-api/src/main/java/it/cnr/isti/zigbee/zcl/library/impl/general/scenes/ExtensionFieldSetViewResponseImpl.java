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

package it.cnr.isti.zigbee.zcl.library.impl.general.scenes;


import java.util.Enumeration;
import java.util.Hashtable;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.ZBDeserializer;
import it.cnr.isti.zigbee.zcl.library.api.general.scenes.ExtensionFieldSetViewResponse;
/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 19:00:05 +0300 (Tue, 06 Aug 2013) $)
 *
 */
public class ExtensionFieldSetViewResponseImpl implements
		ExtensionFieldSetViewResponse {

	
	private int clusterId;
	private int[] attributes;
	Hashtable<Integer, Object> set;
	int attribute;
	ZBDeserializer deserializer;
	boolean endSet;
	
	public ExtensionFieldSetViewResponseImpl(ZBDeserializer deserializer){
		this.deserializer = deserializer;
		clusterId = deserializer.read_int();
		int length = deserializer.read_byte();
		endSet = true;
		for (int i = 0; i < length; i++) {
			int attributeId = deserializer.read_short();
			//TODO use the deserializer.readZigBeeType(ZigBeeType)
			Object value = deserializer.readObject(Object.class);
			//TODO: create Attribute and get ZigBee type from attribute
			if (value==null) endSet = false; 
			set.put(attributeId, value);
		}
		return;
		//TODO complete deserializer for extensionFieldSet
 	}
	
	public boolean endSet(){
		return endSet;
	}
	
	
	public int[] getAttributes(int clusterId) {
		Enumeration<Integer> attribute = set.keys();
		int i = 0;
		while(attribute.hasMoreElements())
		{
			attributes[i] = attribute.nextElement();
			i++;
		}	
		return attributes;
	}

	public int getClusterId() {
		return clusterId;
	}

	public Object getValue(int attributeId) {
		return set.get(attributeId);
	}
	
	

}
	

