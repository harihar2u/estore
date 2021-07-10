#!/bin/sh

prop () {
    grep $1 $2|cut -d'=' -f2
}

# 1. Run Flyway
echo "********* Step1: Running Flyway scripts *********"
/flyway/flyway "$@"

if [ $? -eq 0 ]; then
    # 2. Prepare for DbUnit
    echo "********* Step2: Preparing for DbUnit update *********"
    for i in "$@"
    do
    case $i in
        -url=*)
        URL="${i#*=}"
        shift # past argument=value
        ;;
        -driver=*)
        DRIVER="${i#*=}"
        shift # past argument=value
        ;;
        -user=*)
        USER="${i#*=}"
        shift # past argument=value
        ;;
        -password=*)
        PASSWORD="${i#*=}"
        shift # past argument=value
        ;;
        -schemas=*)
        SCHEMA="${i#*=}"
        shift # past argument=value
        ;;
        -configFile=*)
        CONFIGFILE="${i#*=}"
        shift # past argument=value
        ;;
        *)
              # unknown option
        ;;
    esac
    done

    if [ -n $1 ]; then
        COMMAND=$1
    fi

    if [ -z "$URL" ]; then
          URL=$(prop 'flyway.url' ${CONFIGFILE})
    fi
    if [ -z "$DRIVER" ]; then
          DRIVER=$(prop 'flyway.driver' ${CONFIGFILE})
    fi
    if [ -z "$USER" ]; then
          USER=$(prop 'flyway.user' ${CONFIGFILE})
    fi
    if [ -z "$PASSWORD" ]; then
          PASSWORD=$(prop 'flyway.password' ${CONFIGFILE})
    fi
    if [ -z "$SCHEMA" ]; then
          SCHEMA=$(prop 'flyway.schemas' ${CONFIGFILE})
    fi

    echo "URL           = ${URL}"
    echo "DRIVER        = ${DRIVER}"
    echo "USER          = ${USER}"
    echo "PASSWORD      = ****"
    echo "SCHEMA        = ${SCHEMA}"
    echo "CONFIGFILE    = ${CONFIGFILE}"
    echo "COMMAND       = ${COMMAND}"

    # 3. Run Remanining Migration Scripts
    echo "********* Step3: Running Remanining Migration scripts *********"
    if [ "migrate" = "$COMMAND" ]
    then
        . /runMigration.sh
    else
        echo "migrate command is not passed so skipping DbUnit step"
    fi
fi
