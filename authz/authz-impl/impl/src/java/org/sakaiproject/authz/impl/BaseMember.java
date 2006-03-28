/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/trunk/sakai/admin-tools/su/src/java/org/sakaiproject/tool/su/SuTool.java $
 * $Id: SuTool.java 5970 2006-02-15 03:07:19Z ggolden@umich.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2003, 2004, 2005, 2006 The Sakai Foundation.
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

package org.sakaiproject.authz.impl;

import org.sakaiproject.authz.api.Member;
import org.sakaiproject.authz.api.Role;

/**
 * <p>
 * BaseMember is an implementation of the AuthzGroup API Member.
 * </p>
 */
public class BaseMember implements Member
{
	/** A fixed class serian number. */
	private static final long serialVersionUID = 1L;

	protected Role role = null;

	protected boolean provided = false;

	protected boolean active = true;

	protected String userId = null;

	public BaseMember(Role role, boolean active, boolean provided, String userId)
	{
		this.role = role;
		this.active = active;
		this.provided = provided;
		this.userId = userId;
	}

	/**
	 * {@inheritDoc}
	 */
	public Role getRole()
	{
		return role;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getUserId()
	{
		return userId;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isProvided()
	{
		return provided;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isActive()
	{
		return active;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setActive(boolean active)
	{
		this.active = active;
	}

	/**
	 * {@inheritDoc}
	 */
	public int compareTo(Object obj)
	{
		if (!(obj instanceof Member)) throw new ClassCastException();

		// if the object are the same, say so
		if (obj == this) return 0;

		// compare by comparing the user id
		int compare = getUserId().compareTo(((Member) obj).getUserId());

		return compare;
	}
}
