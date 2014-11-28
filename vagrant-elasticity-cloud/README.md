# Vagrant, elasticidad y otras movidas del cloud

## Instalar vagrant

Para la asignatura es necesario tener un entorno preparado para arrancar máquinas virtuales. Nos basaremos en vagrant, una tecnología que permite gestionar máquinas virtuales usando virtualbox por debajo. Existen implementaciones de virtualbox y vagrant para diferentes sistemas operativos y arquitecturas. Instala [vagrant](https://www.vagrantup.com/downloads.html) y [virtualbox](https://www.virtualbox.org/wiki/Downloads) siguiendo sus respectivas instrucciones.

Vagrant utiliza una clave privada para poder acceder a las máquinas sin contraseña. Esta clave es una clave insegura que se guarda en la carpeta `~/.vagrant.d/insecure_private_key`. Para utilizar las imágenes que se indican a continuación es necesario sustituir la clave por el fichero `insecure_private_key` de este repositorio.

## Importar las imágenes

Dependiendo de tu arquitectura debes importar la imagen que corresponda:

    vagrant add gortazar/ingweb-comp-nube-32

o

    vagrant add gortazar/ingweb-comp-nube-64

Nota: cuando creas un proyecto indicando la imagen que quieres utilizar y esa imagen se encuentra publicada en Vagrantcloud, puedes obviar hacer `vagrant add`. El comando `vagrant init` se encargará de descargar la imagen si aún no está disponible en local.

## Crear un proyecto

    mkdir my_project && cd my_project
    vagrant init gortazar/ingweb-comp-nube-64

Creamos una carpeta para el proyecto y ejecutamos `vagrant init` para que nos genere un fichero de configuración para nuestra máquina. Si le indicamos el nombre de la imagen en la que nos queremos basar, lo incluye directamente en el fichero. Este fichero se llama `Vagrantfile` y define las características básicas de la máquina como nombre, memoria, o el tipo de red que queremos usar.

Para probar la configuración de la máquina podemos arrancarla y acceder a ella por ssh:

    vagrant up
    vagrant ssh

Por defecto, una máquina vagrant tiene un usuario vagrant que puede acceder por ssh mediante un fichero de clave pública. Además este usuario puede ejecutar comandos con `sudo` sin contraseña. Si no tienes mucha idea de la gestión de permisos en Linux, [aquí](http://es.wikipedia.org/wiki/Sudo) tienes una descripción un poco más extensa.

Una vez dentro de la máquina se pueden ejecutar comandos arbitrarios. Cuando en la documentación de este proyecto se indiquen comandos que deben ser ejecutados desde dentro de una máquina vagrant, se antepondrá `vagrant>` al comando. En el caso de que estemos trabajando con varias máquinas arrancadas a la vez, en lugar de vargant aparecerá el nombre con el que nos estemos refiriendo a la máquina. Por ejemplo `web1>`.

    vagrant> ls -la
    vagrant> sudo apt-get install curl wget
    vagrant> exit

El último comando nos saca de la máquina. Si vamos a seguir trabajando en ella podemos volver a entrar con `vagrant ssh`. Si queremos pararla podemos ejecutar `vagrant halt`, aunque suele ser más normal suspenderla con `vagrant suspend`. Para arrancarla si está parada usamos `vagrant up` de nuevo, y si la habíamos suspendido usamos `vagrant resume`.

Si quieremos destruir la máquina y que se liberen todos los recursos asociados (como uso de disco):

    vagrant destroy

