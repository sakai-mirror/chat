/**********************************************************************************
 * $URL: https://source.sakaiproject.org/contrib/rsmart/dbrefactor/chat/chat-impl/impl/src/java/org/sakaiproject/chat/impl/ChatServiceSqlDefault.java $
 * $Id: ChatServiceSqlDefault.java 3560 2007-02-19 22:08:01Z jbush@rsmart.com $
 ***********************************************************************************
 *
 * Copyright (c) 2004, 2005, 2006 The Sakai Foundation.
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/
package org.sakaiproject.chat.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.sakaiproject.chat.api.ChatServiceSql;



/**
 * methods for accessing chat data in a database.
 */
public class ChatServiceSqlDefault implements ChatServiceSql {

   // logger
   protected final transient Log logger = LogFactory.getLog(getClass());


   /**
    * returns the sql statement which retrieves the list of chat messages from the specified table.
    */
   public String getListMessagesSql(String table) {
      return "select CHANNEL_ID, MESSAGE_ID, XML from " + table /* + " where OWNER is null" */;
   }

   /**
    * returns the sql statement which updates a chat message in the specified table.
    */
   public String getUpdateMessageSql(String table) {
      return "update " + table + " set OWNER = ?, DRAFT = ? where CHANNEL_ID = ? and MESSAGE_ID = ?";
   }
}
