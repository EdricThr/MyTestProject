#!/bin/sh
set -e

##########################################################
# kmail安装程序    执行方式：sh setup.sh
# by yingzf
##########################################################

echo "============开始安装邮件系统(start install mail system)============"
sleep 5

#################### global define ################################################
KMAIL_SYSTEM_CONFIG_FILE_PATH=/kmail/conf/kmail.ini
CUR_DATE_STR=$(date +%Y-%m-%d-%H-%M-%S)
CUR_DIR=$(pwd)
HOME_DIR=$CUR_DIR
SETUP_CONF=$CUR_DIR/setup.conf
HOME_KMAIL_DIR=$HOME_DIR/mailmain
HOME_KMAIL_SERVICE_DIR=$HOME_KMAIL_DIR/service
HOME_PACKAGE_DIR=$HOME_DIR/package
HOME_PACKAGE_CUSTOM_DIR=${HOME_PACKAGE_DIR}/custom
KMAIL_VERSION_DESC_FILE=/kmail/conf/kmversion

KMAIL_DIR=/kmail

JAVA_DIR=/usr/local/java
APR_DIR=/usr/local/apr
MYSQL_DIR=/usr/local/mysql
PAM_MYSQL=/lib64/security/pam_mysql.so
PAM_CONF=/etc/pam.d/smtp
CYTUS_SASL_CONF=/etc/sasl2/smtpd.conf
SASLAUTHD_CONF=/etc/sysconfig/saslauthd
TOMCAT_DIR=/usr/local/tomcat
TOMCAT_DEPLOY_PATH=$TOMCAT_DIR/webapps
OPENLDAP_DIR=/usr/local/openldap
BerkeleyDB_DIR=/usr/local/berkeleydb

####################   function define #############################################
##获得ini配置文件中的项值，没有此项则返回空
##参数1：ini文件全路径    参数2：ini中的section   参数3：需要获取的项key名称
getIniItemVal(){
    iniFile=$1
    iniSection=$2
    key=$3
    sed -n "/^\[${iniSection}]/,/^\[/p" ${iniFile} | grep -e "^${key} *=.*">/dev/null 2>&1 || {
        echo
        return 0
    }
    value=`sed -n "/^\[${iniSection}]/,/^\[/p" ${iniFile} | grep -e "^${key} *=.*"`
    value=`echo ${value#$key}`
    value=`echo ${value#=}`
    echo $value | tr -d "\015"
}


##添加ini配置文件中的项值,如果该项已存在,则不再重复添加,也不做任何修改
##参数1：ini文件全路径    参数2：ini中的section   参数3：需要添加的项key名称
##参数4：需要添加的项value值
addIniItemVal(){
    iniFile=$1
    iniSection=$2
    key=$3
    value=$4
    sed -n "/^\[${iniSection}]/,/^\[/p" ${iniFile} | grep -e "^${key} *=.*">/dev/null 2>&1 || {
        sed -i "/^\[$iniSection]/a\\${key} = ${value}" ${iniFile}
        return 0
    }
}

##修改ini配置文件中项值，没有此项则会添加
##参数1：ini文件全路径    参数2：ini中的section   参数3：需要修改的项key名称
##参数4：需要修改的项value值
modiIniItemVal(){
    iniFile=$1
    iniSection=$2
    key=$3
    value=$4
    sed -n "/^\[${iniSection}]/,/^\[/p" ${iniFile} | grep -e "^${key} *=.*">/dev/null 2>&1 || {
        sed -i "/^\[$iniSection]/a\\${key} = ${value}" ${iniFile}
        return 0
    }
    sed -i "/^\[${iniSection}]/,/^\[/s#^${key} *=.*#${key} = ${value}#g" ${iniFile}
}

##删除ini配置文件中的项
##参数1：ini文件全路径    参数2：ini中的section   参数3：需要删除的项key名称
delIniItem(){
    iniFile=$1
    iniSection=$2
    key=$3
    sed -i "/^\[${iniSection}]/,/^\[/s/^${key} *=.*/toDelKey = /g" ${iniFile}
    sed -i "/^toDelKey *=.*/"d ${iniFile}
}

##记安装日志
log()
{
    message=$1
    echo $(date)--$message >> $SETUP_LOG
}

##记录使用的kmail的系统的版本使用历史版本信息###
recordKmailVersion(){
	kversion=$1
	if [ ! -f $KMAIL_VERSION_DESC_FILE ]; then
	   touch $KMAIL_VERSION_DESC_FILE
	fi
	dateStr=$(date +%Y-%m-%d_%T)
	echo "${dateStr} ${kversion}" >> $KMAIL_VERSION_DESC_FILE
}

function installCustom()
{
	mkdir -p $KMAIL_DIR/custom
	mkdir -p $KMAIL_DIR/custom/mailapprove
	mkdir -p $KMAIL_DIR/custom/usync
	mkdir -p $KMAIL_DIR/custom/newmail
	mkdir -p $KMAIL_DIR/custom/sign
	mkdir -p $KMAIL_DIR/custom/synUserAndDept
	mkdir -p $KMAIL_DIR/custom/zcwebserviceclient
	mkdir -p $KMAIL_DIR/custom/portal
	mkdir -p $KMAIL_DIR/custom/dslsync
	
	##审批代办推送##
	tar -xvf $HOME_PACKAGE_CUSTOM_DIR/mail-custom-approve.tar.gz -C $KMAIL_DIR/custom/mailapprove
	dos2unix $KMAIL_DIR/custom/mailapprove/bin/*.sh
	chmod +x $KMAIL_DIR/custom/mailapprove/bin/*.sh

	##用户同步##
	tar -xvf $HOME_PACKAGE_CUSTOM_DIR/mail-custom-usync.tar.gz -C $KMAIL_DIR/custom/usync
	dos2unix $KMAIL_DIR/custom/usync/bin/*.sh
	chmod +x $KMAIL_DIR/custom/usync/bin/*.sh

	##新邮件提醒##
	tar -xvf $HOME_PACKAGE_CUSTOM_DIR/knewmailnotify.tar -C $KMAIL_DIR/custom/newmail
	dos2unix $KMAIL_DIR/custom/newmail/bin/*.sh
	chmod +x $KMAIL_DIR/custom/newmail/bin/*.sh

    ##统一用户管理##
	tar -xvf $HOME_PACKAGE_CUSTOM_DIR/kmail-synUserAndDept.tar.gz -C $KMAIL_DIR/custom/synUserAndDept
	dos2unix $KMAIL_DIR/custom/synUserAndDept/*.sh
	chmod +x $KMAIL_DIR/custom/synUserAndDept/*.sh

	##统一用户管理##
	tar -xvf $HOME_PACKAGE_CUSTOM_DIR/kmail-zcwebserviceclient.tar.gz -C $KMAIL_DIR/custom/zcwebserviceclient
	dos2unix $KMAIL_DIR/custom/zcwebserviceclient/*.sh
	chmod +x $KMAIL_DIR/custom/zcwebserviceclient/*.sh
	
	##portal集成刷新##
	tar -xvf $HOME_PACKAGE_CUSTOM_DIR/kmail-portal.tar.gz -C $KMAIL_DIR/custom/portal
	dos2unix $KMAIL_DIR/custom/portal/*.sh
	chmod +x $KMAIL_DIR/custom/portal/*.sh

	##设备密级同步##
	tar -xvf $HOME_PACKAGE_CUSTOM_DIR/mail-custom-dsl.tar.gz -C $KMAIL_DIR/custom/dslsync
	dos2unix $KMAIL_DIR/custom/dslsync/bin/*.sh
	chmod +x $KMAIL_DIR/custom/dslsync/bin/*.sh
}

compareVerArray() {
    arr1=$1
    arr2=$2
    index=$3
    [ "x"${arr1[$index]} == "x" ] && [ "x"${arr2[$index]} == "x" ] && {
        echo 0
        return
    }
    [ "x"${arr1[$index]} == "x" ] && arr1[$index]=0
    [ "x"${arr2[$index]} == "x" ] && arr2[$index]=0
    [ ${arr1[$index]} -eq ${arr2[$index]} ] && {
        ret=`compareVerArray $arr1 $arr2 $[index+1]`
        echo $ret
        return
    }
    if [ ${arr1[$index]} -gt ${arr2[$index]} ];then
        echo 1
    else
        echo -1
    fi
    return
}
#比较版本大小
#$1>$2  return 1
#$1==$2  return 0
#$1<$2  return -1
#e.g.
#[ $(versionCompare $1 $2) -eq -1 ] && echo "$1版本小于$2版本"
#[ $(versionCompare $1 $2) -eq 0 ] && echo "$1版本等于$2版本"
#[ $(versionCompare $1 $2) -eq 1 ] && echo "$1版本大于$2版本"
#[ $(versionCompare $1 $2) -ge 0 ] && echo "$1版本大于等于$2版本"
versionCompare() {
    OLD_IFS="$IFS"
    IFS="."
    arr1=($1)
    arr2=($2)
    IFS="$OLD_IFS"
    ret=`compareVerArray $arr1 $arr2 0`
    echo $ret
    return
}

function prapareSystem(){
val=`lsb_release -a |grep Release`
val=`echo ${val#Release}`
val=`echo ${val#:}`
if [ `versionCompare $val 5` -ge 0 ] && [ `versionCompare $val 7` -eq -1 ] ; then
    if [ `versionCompare $val 6` -ge 0 ]; then
        curDirs=$(pwd)
        cd $HOME_PACKAGE_DIR
        rm -rf temp
        mkdir temp
        cp kmail3.0.0-for6-preinstall.tar.gz temp
        cd temp
        tar -zxvf kmail3.0.0-for6-preinstall.tar.gz
        sh setup.sh
        cd ${curDirs}
    fi
else 
    echo "系统版本错误,不能执行安装!"
    exit 1
fi
}

#################### init system env ################################################
### 检测操作系统位数,如果非64位操作系统,则退出
SYSBIT=`getconf LONG_BIT`
if [ X"$SYSBIT" != X"64" ]; then
    echo "当前系统非x64,不能执行安装!"
    exit 1
fi

### 检查配置文件是否存在，不存在则退出
if [ ! -e $SETUP_CONF ]; then
    echo "setup.conf not found"
    exit 1
fi

### 检查邮件目录是否存在，如果存在则提示是否继续，继续的话，邮件目录将会被清除
if [ -e $KMAIL_DIR/kms ]; then
    echo -n "安装程序发现本系统已经安装过邮件系统，如果继续安装，将删除原邮件系统的所有数据?(y：继续安装    n：中止安装)"
    read ANS
    case $ANS in
    y)
    ;;
    n|*)
    exit 0
    ;;
    esac
fi

### 检测是否需要执行预安装包
prapareSystem

dos2unix $SETUP_CONF

### 配置setup log
mkdir -p $HOME_DIR/log
SETUP_LOG=$HOME_DIR/log/setup_${CUR_DATE_STR}.log
touch $SETUP_LOG
echo "

" >> $SETUP_LOG
log "***************************************start setup"


### 系统默认字符集是否适配，如果不适配，则改动
sysLang=`echo $LANG`
echo $sysLang | grep "zh_CN.GB18030" > /dev/null 2>&1 || {
    flag=1
    sed -i "s/${sysLang}/zh_CN.GB18030/" `grep "LANG=*" -rl /etc/sysconfig/i18n` && {
       source /etc/sysconfig/i18n
       flag=0
    }
    if [ "$flag" == "1" ]; then
        echo "系统检测系统语言环境或自动修改失败，请手工设置系统语言环境为zh_CN.GB18030，再继续执行安装操作！"
        exit 1
    fi
}
log "系统默认字符集测试或修改结束"


### clear old
#使用更多的信息，防止有其他的端口中包含80，但不是java进程
netstat -ant |grep -e ":3306 .*LISTEN" >/dev/null 2>&1 && killall mysqld
netstat -ant |grep -e ":80 .*LISTEN" >/dev/null 2>&1 && killall java

rm -rf $JAVA_DIR $APR_DIR $MYSQL_DIR $TOMCAT_DIR $OPENLDAP_DIR $BerkeleyDB_DIR
rm -rf $PAM_MYSQL $CYTUS_SASL_CONF
rm -rf /usr/sbin/post* /usr/sbin/sendmail /usr/libexec/postfix /var/lib/postfix /var/spool/postfix /etc/postfix
rm -rf /etc/cron.d/*.task

rm -rf $KMAIL_DIR
log "$KMAIL_DIR删除结束"

log "清除老程序结束"

### disabled selinux
SELINUX_CONFIG=/etc/selinux/config
sed -i 's/SELINUX=enforcing/SELINUX=disabled/g' $SELINUX_CONFIG


#################### add user group ######################################
# 因为在解压env包时，包里有些文件已经有归属于某用户或组权限了，所以在解压前要将系统的用户组修改好
# mysql
grep "^mysql:" /etc/passwd >/dev/null 2>&1 && userdel mysql
grep "^mysql:" /etc/group >/dev/null 2>&1 && groupdel mysql
groupadd -g 50000 mysql
useradd -g 50000 -u 50000 mysql

# postfix
[ `userdel -fr postfix` ] || echo ""
grep "^postfix:" /etc/group >/dev/null 2>&1 && groupdel postfix
grep "^postdrop:" /etc/group >/dev/null 2>&1 && groupdel postdrop
groupadd -g 50010 postfix
#useradd -g 50010 -u 50010 postfix -d /dev/null -s /bin/false
useradd -g 50010 -u 50010 postfix
groupadd -g 50020 postdrop

# mail
grep "^mailowner:" /etc/passwd >/dev/null 2>&1 && userdel mailowner
grep "^mailowner:" /etc/group >/dev/null 2>&1 && groupdel mailowner
groupadd -g 999999 mailowner
useradd -g 999999 -u 999999 mailowner

log "用户和组修改结束"

#################### install package ######################################
### jdk
tar -zxvf $HOME_PACKAGE_DIR/jdk.tar.gz -C /
log "jdk安装结束"

### bdb
tar -zxvf $HOME_PACKAGE_DIR/bdb.tar.gz -C /
log "bdb安装结束"

### openldap
tar -zxvf $HOME_PACKAGE_DIR/openldap.tar.gz -C /
log "openldap安装结束"

### apr
tar -zxvf $HOME_PACKAGE_DIR/apr.tar.gz -C /
log "apr安装结束"

### mysql
tar -zxvf $HOME_PACKAGE_DIR/mysql.tar.gz -C /
log "mysql安装结束"

###pam_mysql
tar -zxf $HOME_PACKAGE_DIR/pam_mysql.tar.gz -C /
mv /usr/lib/security/pam_mysql.so $PAM_MYSQL
chmod +x $PAM_MYSQL
log "pam_mysql安装结束"

### postfix
tar -zxvf $HOME_PACKAGE_DIR/postfix.tar.gz -C /
log "postfix安装结束"

### tomcat
tar -zxvf $HOME_PACKAGE_DIR/tomcat.tar.gz -C /
log "tomcat安装结束"

### sysstat
tar -zxvf $HOME_PACKAGE_DIR/sysstat-kmail.tar.gz -C /
cp -rf $HOME_PACKAGE_DIR/readme_sysstat.txt /usr/local/sysstat/
log "sysstat安装结束"

### 7zip
curDirs=$(pwd)
cd $HOME_PACKAGE_DIR
tar -xvf p7zip_9.20.1_x86_linux_bin.tar
cd p7zip_9.20.1
./install.sh
cd ${curDirs}
log "7zip安装结束"

### btrace
mkdir -p /kmail/tool/btrace/btracebin
tar -zxvf $HOME_PACKAGE_DIR/btrace/btrace-bin.tgz -C /kmail/tool/btrace/btracebin/
log "btrace安装结束"
#################### config java ###################################################
### ADD BC PROVIDER
JAVA_SECURITY_CONF=$JAVA_DIR/jre/lib/security/java.security
sed -i '/^security.*SunPCSC/a\security\.provider\.10=org\.bouncycastle\.jce\.provider\.BouncyCastleProvider' $JAVA_SECURITY_CONF
log "jdk配置修改结束"

#################### config mysql ##################################################
MYSQL_SERVER=$MYSQL_DIR/mysql.server

if ! grep "/usr/lib/mysql/lib" /etc/ld.so.conf >/dev/null 2>&1; then
    echo '/usr/lib/mysql/lib' >> /etc/ld.so.conf
fi
ldconfig

rm -rf /etc/init.d/mysqld
mv $MYSQL_SERVER /etc/init.d/mysqld
chmod +x /etc/init.d/mysqld
cp -rf $HOME_KMAIL_DIR/conf/mysql/my.cnf /etc/

chkconfig --del mysqld
chkconfig --add mysqld
chkconfig --level 2345 mysqld on
service mysqld start
log "mysql配置修改结束并启动mysql服务"

$MYSQL_DIR/bin/mysqladmin -u root -h localhost password 'KmailDbRoot2012!'
$MYSQL_DIR/bin/mysql -u root -pKmailDbRoot2012! < $HOME_KMAIL_DIR/db/mysql.sql 
log "mysql管理员权限修改结束"

$MYSQL_DIR/bin/mysql -u root -pKmailDbRoot2012! < $HOME_KMAIL_DIR/db/kmailSql.sql
log "数据库脚本导入结束"

#################### config cyrus-sasl ###############################################
cp -rf $HOME_KMAIL_DIR/conf/cyrus-sasl/smtpd.conf $CYTUS_SASL_CONF
dos2unix $CYTUS_SASL_CONF
log "cyrus-sasl配置结束"

#################### config pam_mysql ###############################################
rm -rf /etc/pam.d/smtp /etc/alternatives/mta-pam /etc/pam.d/smtp.sendmail
cp -rf $HOME_KMAIL_DIR/conf/pam/smtp /etc/pam.d/smtp
dos2unix /etc/pam.d/smtp
ln -s /etc/pam.d/smtp /etc/alternatives/mta-pam
ln -s /etc/pam.d/smtp /etc/pam.d/smtp.sendmail
log "pam_mysql配置结束"

#################### config postfix ##################################################
cp -rf $HOME_KMAIL_DIR/conf/postfix/* /etc/postfix/
dos2unix /etc/postfix/bounce.cf
cp -rf $HOME_KMAIL_SERVICE_DIR/mta /etc/init.d/
dos2unix /etc/init.d/mta
chmod +x /etc/init.d/mta
chkconfig --del mta
chkconfig --add mta
chkconfig --level 2345 mta on

#### modify postfix log path
if [ -f /etc/syslog.conf ]; then
    sed -i 's/^mail\..*\/var\/log\/maillog/mail\.*                           -\/kmail\/logs\/maillog.log/g' /etc/syslog.conf
fi
if [ -f /etc/rsyslog.conf ]; then
    sed -i 's/^mail\..*\/var\/log\/maillog/mail\.*                           -\/kmail\/logs\/maillog.log/g' /etc/rsyslog.conf
fi

log "postfix配置结束"

#################### config saslauthd ###############################################
sed -i 's/FLAGS=.*/FLAGS="-r"/g' $SASLAUTHD_CONF
service saslauthd restart
chkconfig --level 2345 saslauthd on
log "saslauthd配置结束"

#################### config tomcat ###################################################
cp -rf $HOME_KMAIL_SERVICE_DIR/tomcat /etc/init.d/
dos2unix /etc/init.d/tomcat
chmod +x /etc/init.d/tomcat

chkconfig --del tomcat
chkconfig --add tomcat
chkconfig --level 2345 tomcat on

#### modify catalina.sh
cp -rf $HOME_KMAIL_DIR/conf/tomcat/catalina.sh $TOMCAT_DIR/bin/
#### modify server.xml
cp -rf $HOME_KMAIL_DIR/conf/tomcat/server.xml $TOMCAT_DIR/conf/
#### modify tomcat-users.xml--add manager user
sed -i '/^<tomcat-users>/a\<user username="kmail" password="kmail" roles="manager-gui,manager-jmx,manager-script,manager-status"/>' $TOMCAT_DIR/conf/tomcat-users.xml

log "tomcat配置结束"

#################### config openldap ###################################################
LDAP_CONF=$OPENLDAP_DIR/etc/openldap/slapd.conf
cp -rf $HOME_KMAIL_SERVICE_DIR/ldap /etc/init.d/
chmod +x /etc/init.d/ldap
chkconfig --del ldap
chkconfig --add ldap
chkconfig --level 2345 ldap on

#### modify LDAP_CONF
sed -i '/^include.*core\.schema/a\include         \/usr\/local\/openldap\/etc\/openldap\/schema\/nis.schema' $LDAP_CONF
sed -i '/^include.*core\.schema/a\include         \/usr\/local\/openldap\/etc\/openldap\/schema\/openldap.schema' $LDAP_CONF
sed -i '/^include.*core\.schema/a\include         \/usr\/local\/openldap\/etc\/openldap\/schema\/misc.schema' $LDAP_CONF
sed -i '/^include.*core\.schema/a\include         \/usr\/local\/openldap\/etc\/openldap\/schema\/inetorgperson.schema' $LDAP_CONF
sed -i '/^include.*core\.schema/a\include         \/usr\/local\/openldap\/etc\/openldap\/schema\/cosine.schema' $LDAP_CONF
sed -i '/^include.*core\.schema/a\include         \/usr\/local\/openldap\/etc\/openldap\/schema\/corba.schema' $LDAP_CONF
sed -i '/^argsfile.*slapd\.args/a\\nloglevel 256' $LDAP_CONF
sed -i '/^argsfile.*slapd\.args/a\\nsizelimit unlimited' $LDAP_CONF

sed -i "s/^suffix.*dc=my-domain,dc=com.*/suffix           \"o=mail\"/g" $LDAP_CONF
sed -i "s/^rootdn.*cn=Manager,dc=my-domain,dc=com.*/rootdn           \"cn=Manager, o=mail\"/g" $LDAP_CONF
sed -i '/^# Indices to maintain/a\index mail eq' $LDAP_CONF

#### modify SYSLOG_CONF
syslogconf=/etc/syslog.conf
if [ -f /etc/rsyslog.conf ]; then
    syslogconf=/etc/rsyslog.conf
fi
if ! grep "/kmail/logs/ldap.log" $syslogconf >/dev/null 2>&1; then
    echo "local4.*                                                /kmail/logs/ldap.log" >> $syslogconf
fi

log "openldap配置结束"

#################### config kmail ###################################################


mkdir -p $KMAIL_DIR
mkdir -p $KMAIL_DIR/logs
mkdir -p $KMAIL_DIR/logs/mysql
mkdir -p $KMAIL_DIR/services
mkdir -p $KMAIL_DIR/script
mkdir -p $KMAIL_DIR/custom
mkdir -p $KMAIL_DIR/tool
mkdir -p $KMAIL_DIR/client
mkdir -p $KMAIL_DIR/conf
mkdir -p $KMAIL_DIR/certs/chain
mkdir -p $KMAIL_DIR/temp/mail
mkdir -p $KMAIL_DIR/temp/web
mkdir -p $KMAIL_DIR/temp/attachment
mkdir -p $KMAIL_DIR/temp/smdecattach
mkdir -p $KMAIL_DIR/download
mkdir -p $KMAIL_DIR/download/flash
mkdir -p $KMAIL_DIR/assistant
mkdir -p $KMAIL_DIR/kms
mkdir -p $KMAIL_DIR/apps
mkdir -p $KMAIL_DIR/files

mkdir -p $KMAIL_DIR/files/harddrive
mkdir -p $KMAIL_DIR/files/backup
mkdir -p $KMAIL_DIR/files/mail
mkdir -p $KMAIL_DIR/files/mail/outdomainmail
mkdir -p $KMAIL_DIR/files/mail/encrptmail
mkdir -p $KMAIL_DIR/files/mail/attachment

chown -R mailowner:mailowner $KMAIL_DIR/files/mail/outdomainmail
chown -R mysql:mysql $KMAIL_DIR/logs/mysql

###flash plugin###
cp -rf $HOME_PACKAGE_DIR/flash/* $KMAIL_DIR/download/flash

### kmail.zip
####$TOMCAT_DEPLOY_PATH####
cd $KMAIL_DIR/apps
unzip $HOME_PACKAGE_DIR/kmail.zip
mv kmail web
ln -s $KMAIL_DIR/apps/web $TOMCAT_DEPLOY_PATH/kmail
log "mail.zip安装结束"

### assistant
tar -zxvf $HOME_PACKAGE_DIR/assistant.tar.gz -C $KMAIL_DIR/assistant
log "assistant安装结束"

### kms
rm -f /etc/init.d/kms
tar -zxvf $HOME_PACKAGE_DIR/koal-kms.tar.gz -C $KMAIL_DIR/kms
dos2unix $KMAIL_DIR/kms/bin/kms.sh
chmod +x $KMAIL_DIR/kms/bin/kms.sh
ln -s $KMAIL_DIR/kms/bin/kms.sh /etc/init.d/kms
chkconfig --del kms
chkconfig --add kms
chkconfig --level 2345 kms on
log "kms安装结束"

### conf
cp -rf $HOME_KMAIL_DIR/conf/kmail.ini $KMAIL_DIR/conf
cp -rf $HOME_KMAIL_DIR/conf/kmail-logrotate.conf $KMAIL_DIR/conf
cp -rf $HOME_KMAIL_DIR/conf/antisamyPolicy.xml $KMAIL_DIR/conf
cp -rf $HOME_KMAIL_DIR/conf/kmailx_private_key.dat $KMAIL_DIR/conf
dos2unix $KMAIL_DIR/conf/kmail.ini
dos2unix $KMAIL_DIR/conf/kmail-logrotate.conf

cp -rf $HOME_KMAIL_DIR/conf/backup/restore.ini $KMAIL_DIR/files/backup
dos2unix $KMAIL_DIR/files/backup/restore.ini
log "conf拷贝结束"

### conf modi
kmailIni=$KMAIL_DIR/conf/kmail.ini
cat $SETUP_CONF | while read line; do
	if [ x"${line}" == x"" ]; then
		continue
	fi
    section=${line%%|*}
    section=$(echo $section)
    keyvalue=${line#*|}
    key=${keyvalue%%=*}
    key=$(echo $key)
    value=${keyvalue#*=}
    value=$(echo $value)
    if [ x$section != x"" ] && [ x$key != x"" ]
    then
        modiIniItemVal $kmailIni $section "$key" "$value"
    fi
done

log "conf修改结束"

cp -rf $HOME_KMAIL_DIR/script/* $KMAIL_DIR/script
cd /
find $KMAIL_DIR/script -name "*.*" -exec dos2unix {} \;
find $KMAIL_DIR/script -name "*.*" -exec chmod +x {} \;

installCustom

cd /
cp -rf $HOME_KMAIL_DIR/tool/* $KMAIL_DIR/tool
find $KMAIL_DIR/tool -name "*.sh" -exec dos2unix {} \;
find $KMAIL_DIR/tool -name "*.sh" -exec chmod +x {} \;
find $KMAIL_DIR/tool -name "*.py" -exec dos2unix {} \;
find $KMAIL_DIR/tool -name "*.py" -exec chmod +x {} \;

cp -rf $HOME_KMAIL_DIR/client/* $KMAIL_DIR/client

cp -rf $HOME_KMAIL_SERVICE_DIR/* $KMAIL_DIR/services
dos2unix $KMAIL_DIR/services/*
chmod +x $KMAIL_DIR/services/*
ln -sf $KMAIL_DIR/services/mta /etc/init.d/mta
ln -sf $KMAIL_DIR/services/ldap /etc/init.d/ldap
ln -sf $KMAIL_DIR/services/tomcat /etc/init.d/tomcat

###crond
cp -rf $HOME_KMAIL_DIR/crond/* /etc/cron.d

grep "^* *- *nofile *1000000" /etc/security/limits.conf || {
    echo "*      -       nofile  1000000" >> /etc/security/limits.conf
}

grep "net.ipv4.tcp_max_syn_backlog = 65536" /etc/sysctl.conf || {
    echo "net.ipv4.tcp_max_syn_backlog = 65536" >> /etc/sysctl.conf
}

grep "export JAVA_HOME=/usr/local/java TOMCAT_HOME=/usr/local/tomcat" /etc/profile >/dev/null 2>&1|| {
    echo "export JAVA_HOME=/usr/local/java TOMCAT_HOME=/usr/local/tomcat" >> /etc/profile
}

grep "export CLASSPATH=\$CLASSPATH:\$JAVA_HOME/lib:\$JAVA_HOME/jre/lib PATH=\$JAVA_HOME/bin:\$JAVA_HOME/jre/bin:\$PATH" /etc/profile >/dev/null 2>&1|| {
    echo "export CLASSPATH=\$CLASSPATH:\$JAVA_HOME/lib:\$JAVA_HOME/jre/lib PATH=\$JAVA_HOME/bin:\$JAVA_HOME/jre/bin:\$PATH" >> /etc/profile
}

#extra
dos2unix $HOME_KMAIL_DIR/setup-extra/*.sh
chmod +x $HOME_KMAIL_DIR/setup-extra/*.sh
grep "setupExtraFile" $SETUP_CONF && {
    setupExtraFile=`grep "setupExtraFile" $SETUP_CONF | awk -F "=" '{print $2}'`
    sh $HOME_KMAIL_DIR/setup-extra/$setupExtraFile
}

###记录版本信息至版本升级演化描述文件###
#获取当前系统的版本信息
sysVersion=`getIniItemVal $KMAIL_SYSTEM_CONFIG_FILE_PATH SysCfg sysVersion`
sysPatch=`getIniItemVal $KMAIL_SYSTEM_CONFIG_FILE_PATH SysCfg sysPatch`
[ "x$sysPatch" != "x" ] && sysPatch=patch$sysPatch
sysVersionInfo=$sysVersion$sysPatch
recordKmailVersion $sysVersionInfo
echo "====邮件系统安装成功===="

echo "====开始进行性能参数优化"
sh /kmail/tool/performanceTuning.sh -a
echo "====性能参数优化成功"

echo "====安装成功，请手工重启服务器后进行部署(mail system install successful, please deploy after manual reboot)===="
echo "====部署URL地址(deploy url): http://ip/admin===================================================================="
