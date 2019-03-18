For the ansible project :

- first create the "ansible" folder in /home/dev
- chown the ansible folder to jenkins user instead of dev user




#Solr :



install solr : https://dzone.com/articles/how-to-install-apache-solr-on-ubuntu-1604

sudo -u solr ./solr create -c cassandra_employee


https://stackoverflow.com/questions/17922696/how-to-select-rows-in-cassandra-for-indexing-in-solr

vs

https://snapdev.net/2017/08/03/install-solr-on-ubuntu-14-04-or-16-06-without-datastax-dse/




safe uninstall solr :

sudo service solr stop
sudo rm -r /var/solr
sudo rm -r /opt/solr-8.0.0
sudo rm -r /opt/solr
sudo rm /etc/init.d/solr
sudo deluser --remove-home solr
sudo deluser --group solr