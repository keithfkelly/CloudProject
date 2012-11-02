<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="default.css" rel="stylesheet" type="text/css">
		<title> TrainTimer - Getting you there!</title>

</head>
<body>
<div id="header">
	<div id="logo">
		<h1>TrainTimer</a></h1>
		<h2>Getting You There!</h2>
	</div>
	<div id="menu">
	<br />
	Cloud Computing <br/>
	Keith Kelly<br />
	BSCHE4<br />
	09104844
	</div>
</div>
<div id="content">
	<div id="colOne">
	<form action="TrainServlet">			
			 <B>Please Select a Station: </B><br/>
			 <br />
			 <select name="StationCode">
				<option value="MHIDE">Malahide</option>
				<option value="PMNCK">Portmarnock</option>
				<option value="GRGRD">Clongriffin</option>
				<option value="SUTTN">Sutton</option>
				<option value="BYSDE">Bayside</option>
				<option value="HWTHJ">Howth Junction</option>
				<option value="HOWTH">Howth</option>
				<option value="KBRCK">Kilbarrack</option>
				<option value="RAHNY">Raheny</option>
				<option value="HTOWN">Harmonstown</option>
				<option value="KLSTR">Killester</option>
				<option value="CTARF">Clontarf Road</option>
				<option value="CNLLY">Dublin Connolly</option>
				<option value="TARA">Tara Street</option>
				<option value="PERSE">Dublin Pearse</option>
				<option value="GCDK">Grand Canal Dock</option>
				<option value="LDWNE">Lansdowne Road</option>
				<option value="SMONT">Sandymount</option>
				<option value="SIDNY">Sydney Parade</option>
				<option value="BTSTN">Booterstown</option>
				<option value="BROCK">Blackrock</option>
				<option value="SEAPT">Seapoint</option>
				<option value="SHILL">Salthill</option>
				<option value="DLERY">Dun Laoghaire</option>
				<option value="SCOVE">Sandycove</option>
				<option value="GLGRY">Glenageary</option>
				<option value="DLKEY">Dalkey</option>
				<option value="KILNY">Killiney</option>
				<option value="SKILL">Shankill</option>
				<option value="BRAY">Bray</option>
				<option value="GSTNS">Greystones</option>
				<option value="KCOOL">Kilcoole</option>
			</select>
			<br />
			<br />
			<input type="submit" value="submit">
								
		</form>	
		
	</div>
	
</div>
<div id="footer">
	<p></p>
</div>
</body>
</html>