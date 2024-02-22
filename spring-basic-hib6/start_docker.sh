#!/bin/bash

export ACEISS_API_KEY=TG0l6xGCGGONivYkFJeAnIMhY0MDN9CQwf8wo9Esc1QcNjjI01eM-NAcmkPSgNpyWapYFm.I1M--l5K1amQr_d6V4SF1wdWHcIyvXB4luj-cJ4xmwiRMqsWwo5xL6XsT8AgV2zioJ7MgmXKhyMehKhBoEYXDlVZkvHRKwLBdclyygziSSUB7dVU0PQRFAYOpLDWCfUjQeB7W6jA_elS_vkYHx_3AUOD0sUFsMR0bdmfM5rjd9hjfpphPAP6bmZXDWyRr2YcQFptBWx2dALtxxPlaVMNwNoxWR00JX2DWb5XKSkexport ACEISS_AGENT_PATH=/Users/EricB/aceiss/mac/javaagent/agent/build/libs
export HOST_PORT=8080
#4 hrs
export ACEISS_USER_LIST_REFRESH_DELAY=360
export ACEISS_USER_LIST_REFRESH_DELAY=13:10:11
export ACEISS_API_ENDPOINT=http://localhost:4318/
docker-compose up


export ACEISS_USER_LIST_QUERY="SELECT emp.*, roles.NAME as ROLE FROM BLC_ADMIN_USER emp JOIN BLC_ADMIN_USER_ROLE_XREF rxref on emp.admin_user_id = rxref.admin_user_id JOIN BLC_ADMIN_ROLE roles on rxref.admin_role_id = roles.admin_role_id"
