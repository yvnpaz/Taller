<h1> Taller </h1>
<h4> -  WorkShop: taller mecánico que permite gestionar los servicios que se pueden ofrecer a un vehiculo.</h4>
<h2> Tipo de proyecto Maven </h2>
<h3>Estructura</h3>
<ul>
    <li>Domain</li>
    <li>Repository</li>
    <li>Main</li>
</ul>

<h3>Empleabilidad de software</h3>
<h4>Patrones de diseño</h4>
<ul>
<li>Patrón Observer</li>
<p>Notifica que se ha cambiado el estado de un servicio.</p>
</ul>

<h4>Concurrencia</h4>
<ul>
  <li>Thread</li>
  <p>Se cambia el estado de un servicio a otro, cuando pase el tiempo de realización de una determindada acción.</p>
</ul>

<h4>Modelado de datos</h4>
<ul>
  <li>Gestor de BD -> <b>SQLITE</b></li>
  <p>Se guardan los datos de la aplicación.</p>
  <p>Se genera una cache con los datos anteriormente guardados.</p>
</ul>
