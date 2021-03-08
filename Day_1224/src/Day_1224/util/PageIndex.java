package Day_1224.util;

import java.net.URLEncoder;

public class PageIndex {
	public static String pageList(int page,int totpage,String url,String addtag) {
		int idx_pre, idx_start;
		  	
		String s_pre = "";    // Prev ���옣 蹂��닔
		String s_idx = "";    // 踰덊샇 ���옣 蹂��닔
		String s_next = "";   // Next ���옣 蹂��닔

		idx_start = ((page-1) / 10) * 10 + 1 ;  // �떆�옉 �럹�씠吏� 怨꾩궛
		idx_pre = ((page-1) / 10);              // Priview �럹�씠吏� 怨꾩궛

	  	// Prev �몴�떆 遺�遺�
	  	if(idx_pre > 0) {
	  		s_pre = "<a href='"+url+"?page="+(idx_pre*10)+addtag+"'>"
	  				+ "<img src=./img/i_prev.gif width=30 height=7></a>";
	  	} else {
	  		s_pre = "<img src=./img/i_prev.gif width=30 height=7> ";
	  	}

	  	// 踰덊샇 �몴�떆遺�遺�	
	  	for(int i=0;i<10;i++,idx_start++) {
	  		if(idx_start>totpage) break;
	  		if(idx_start == page)
	  			s_idx = s_idx + " "+idx_start+" ";
	  		else {
	  			s_idx = s_idx + " <a href='" + url + "?page=" + idx_start;
	  			s_idx = s_idx + addtag + "'> " + idx_start + " </a> ";
	  		}
	  	}
		// Next �몴�떆遺�遺�
	  	if(idx_start <= totpage ) {
	  		s_next = "<a href='"+url+"?page="+idx_start+addtag+"'>"
	  				+ "<img src=./img/i_next.gif width=30 height=7></a>";
	  	} else {
	  		s_next = " <img src=./img/i_next.gif width=30 height=7>";
	  	}

	  	String outHtml = s_pre + s_idx + s_next;  // Html 臾� 議고빀
	  	return outHtml;
	}

	public static String pageListHan(int page,int totpage,String url,String query, String key) {
		int idx_pre, idx_start;
		  	
		String s_pre = "";    // Prev ���옣 蹂��닔
		String s_idx = "";    // 踰덊샇 ���옣 蹂��닔
		String s_next = "";   // Next ���옣 蹂��닔

		idx_start = ((page-1) / 10) * 10 + 1 ;  // �떆�옉 �럹�씠吏� 怨꾩궛
		idx_pre = ((page-1) / 10);              // Priview �럹�씠吏� 怨꾩궛

	  	// Prev �몴�떆 遺�遺�
	  	if(idx_pre > 0) {
	  		s_pre = "<a href='"+url+"?page="+(idx_pre*10)+"&search="+query+"&key="+ URLEncoder.encode(key)+"'>"
	  				+ "<img src=Board/img/i_prev.gif width=30 height=7></a>";
	  	} else {
	  		s_pre = "<img src=Board/img/i_prev.gif width=30 height=7> ";
	  	}

	  	// 踰덊샇 �몴�떆遺�遺�	
	  	for(int i=0;i<10;i++,idx_start++) {
	  		if(idx_start>totpage) break;
	  		if(idx_start == page)
	  			s_idx = s_idx + " "+idx_start+" ";
	  		else {
	  			s_idx = s_idx + " <a href='" + url + "?page=" + idx_start;
	  			s_idx = s_idx + "&search="+query+"&key=" + URLEncoder.encode(key) + "'> " + idx_start + " </a> ";
	  		}
	  	}
		// Next �몴�떆遺�遺�
	  	if(idx_start <= totpage ) {
	  		s_next = "<a href='"+url+"?page="+idx_start+ "&search="+query+"&key="+ URLEncoder.encode(key)+"'>"
	  				+ "<img src=Board/img/i_next.gif width=30 height=7></a>";
	  	} else {
	  		s_next = " <img src=Board/img/i_next.gif width=30 height=7>";
	  	}

	  	String outHtml = s_pre + s_idx + s_next;  // Html 臾� 議고빀
	  	return outHtml;
	}

}
