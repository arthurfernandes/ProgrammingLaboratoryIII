#!/bin/bash
DATE='201407060000'
ORIGIN=("RIO" "BSB" "CGH")

TAM='http://book.tam.com.br/TAM/dyn/air/booking/upslDispatcher'

DATA='SITE=JJBKJJBK&LANGUAGE=BR&WDS_MARKET=BR&B_DATE_1='$DATE'&B_LOCATION_1='${ORIGIN[0]}'&E_LOCATION_1='${ORIGIN[1]}'&TRIP_TYPE=O&adults=1&COMMERCIAL_FARE_FAMILY_1=NEWBUNDLE'

echo $DATA

for (( i = 1; i <= ${#ORIGIN[@]}; i++ ))      ### Outer for loop ###
do
 
    for (( j = 1 ; j <= ${#ORIGIN[@]}; j++ )) ### Inner for loop ###
    do
	if [$i -ne $j]; then 
          echo -n "$i "
	  curl $TAM --data $DATA > $DATA${ORIGIN[$i]}${ORIGIN[$j]}
	fi
    done

done

