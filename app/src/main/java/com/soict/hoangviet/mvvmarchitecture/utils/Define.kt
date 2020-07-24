package com.soict.hoangviet.baseproject.utils

object Define {
    const val PREF_NAME = "app_sharepreference"

    object ResponseStatus {
        const val LOADING = 0
        const val SUCCESS = 1
        const val ERROR = 2
    }

    object ApiService {
        object RelativeUrl {
            const val CONSTRUCTION = "api/v1/kouji"
        }

        object Parameter {
            const val PAGE = "page"
            const val TOKEN = "token"
            const val ID = "id"
            const val FAB_ID = "fab_id"
            const val DATE_START = "date_start"
            const val DATE_FINISH = "date_finish"
            const val SECTION = "section"
            const val KOUJI_ID = "kouji_id"
            const val KEYWORD = "keyword"
            const val SORT = "sort"
            const val PER_PAGE = "per_page"
        }

        object Constant {
            const val LIMIT = 20
        }

        object Header {
            const val AUTHORIZATION_HEADER = "Authorization"
        }
    }
}