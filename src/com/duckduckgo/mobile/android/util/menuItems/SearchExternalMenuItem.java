package com.duckduckgo.mobile.android.util.menuItems;

import com.duckduckgo.mobile.android.R;
import com.duckduckgo.mobile.android.activity.DuckDuckGo;
import com.duckduckgo.mobile.android.util.Action;
import com.duckduckgo.mobile.android.util.Item;

public class SearchExternalMenuItem extends Item {
	private final String query;
	private final DuckDuckGo context;
	
	public SearchExternalMenuItem(DuckDuckGo context, String query){
		super(context.getResources().getString(R.string.OpenInExternalBrowser), android.R.drawable.ic_menu_rotate, ItemType.EXTERNAL);
		this.context = context;
		this.query = query;
		
		this.ActionToExecute = getActionToExecute();
	}

	/** 
	 * we're actually going to call this directly instead of the public field ActionToExecute, after more refactoring
	 * @return
	 */
	public Action getActionToExecute() {
		return new Action() {
			@Override
			public void Execute() {
				context.searchExternal(query);
			};
		};
	}
}