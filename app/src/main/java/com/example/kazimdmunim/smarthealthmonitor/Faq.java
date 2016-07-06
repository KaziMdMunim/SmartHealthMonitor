package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class Faq extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.faq);
        WebView mWebView = (WebView) this.findViewById(R.id.webview);
        if(Config.lang){
//            String text = "<html><body>"
//                    +"<h1 id=\"bls\"><b>Blood Sugar (Diabetes):</b></h1>\n" +
//                    "<ul>"
//                    + "<li>What is Diabetes?</li>"
//                    + "<p align=\"justify\">" + "<font color=\"white\">"
//                    + "When the blood sugar increases due to deficiency of Insulin in blood, then the clinical syndromes are defined as diabetes."
//                    + "</font>"
//                    + "</p> "+"</ul>"
//                    + "</body></html>";

            String text ="<html><body>"
                    + "    <div id=\"site_content\">\n" +
                    "        \n" + "<font color=\"#1c1d26\">" +
                    "\t\t<div class=\"content\">\n" +
                    "\t\t<div class=\"sidebar\">\n" +
                    "\t\t <h1 id=\"faqq\"><b style = \"color : purple\">Frequently Asked Questions</b></h1>\n" +
                    "\t\t <h1 id=\"blp\"><b style = \"color : #0d0d9a\">Blood Pressure:</b></h1>\n" +
                    "          <ul>\n" +
                    "\t\t\t<li>What is the normal range of Blood Pressure?</li>\n" +
                    "\t\t\t<p align=\"justify\"> For adult, the normal range of diastolic and systolic is: 80-120.</p>\n" +
                    "\t\t\t<li>What is Systole?</li>\n" +
                    "\t\t\t<p align=\"justify\"> The phase of the heartbeat when the heart muscle contracts and pumps blood from the chambers into the arteries.</p> \n" +
                    "            <li>What is Diastole?</li>\n" +
                    "\t\t\t<p align=\"justify\">The phase of the heartbeat when the heart muscle relaxes and allows the chambers to fill with blood.</p>\n" +
                    "            \n" +
                    "\t\t\t</li>\n" +
                    "\t\t  </ul>\n" +
                    "\t\t <h1 id=\"pul\"><b style = \"color : #0d0d9a\">Pulse:</b></h1>\n" +
                    "          <ul>\n" +
                    "            <li>What is pulse?</li>\n" +
                    "\t\t\t<p align=\"justify\">At the time of systole and diastole, the wall of the arteries outspread due to the change of pressure on the walls. This is called \"Pulse\". </p>\n" +
                    "\t\t\t<li>What is the normal level of heart pulse?</li>\n" +
                    "\t\t\t<p align=\"justify\">For Adult: 60-100 beats/min</p>\n" +
                    "\t\t\t<p align=\"justify\">Upto 3 years: 100-120 beats/min</p>\n" +
                    "\t\t\t<p align=\"justify\">Children over 3 years: 80-100 beats/min</p>\n" +
                    "\t\t\t<li>What is <i>Tachycardia</i> ?</li>\n" +
                    "\t\t\t<p align=\"justify\"> When heart beat rate is more than 100 beats/min then the state is called <i> Tachycordia</i>.</p>\n" +
                    "\t\t\t<p align=\"justify\"> <b>Cause of <i>Tachycardia</i>:</b></p>\n" +
                    "\t\t\t<p align=\"justify\"> Normally excitement, emotion, physical labour and during pregnancy <i>Tachycordia</i> can be occured. Due to some diseases (like: Fever, Anaemia, Heart diseases) or drugs (like Salbutamol, Atropine etc.) <i>Tachycordia</i> can be felt.</p>\n" +
                    "\t\t\t<li>What is <i>Bradycardia</i> ?</li>\n" +
                    "\t\t\t<p align=\"justify\"> When heart beat rate is less than 60 beats/min then the state is called <i> Bradycordia</i>.</p>\n" +
                    "\t\t\t<p align=\"justify\"> <b>Cause of <i>Bradycardia</i>:</b></p>\n" +
                    "\t\t\t<p align=\"justify\"> Normally Athletic activities and during sleep <i>Bradycordia</i> can be occured. Due to some heart diseases (like: Myocardial Infrarction) or sudden high brain pressure or drugs (like Digoxin, Verapamil etc.) <i>Bradycordia</i> can be felt.</p>\n" +
                    "\t\t\t</ul>\n" +
                    "\t\t <h1 id=\"bm\"><b style = \"color : #0d0d9a\">BMI:</b></h1>\n" +
                    "<ul style=\"color:#1c1d26\">\n" +
                    "\t\t    <li>How to calculate BMI manually?</li>\n" +
                    "\t\t\t<p align=\"justify\"><div style=\"float:left;margin-top:20px;margin-left:45px;color:#1c1d26\">BMI= &nbsp;</div>\n" +
                    "\t\t\t<div style=\"float:left\">\n" +
                    "\t\t\t<div style=\"border-bottom:1px solid;font-size:20px;text-align:center;color:#1c1d26\">Weight in kg</div>\n" +
                    "\t\t\t<div style=\"font-size:20px;text-align:center;margin-bottom:20px;color:#1c1d26\">(Height in meter)<sup>2</sup></div>\n" +
                    "\t\t\t</div></p>\n" +
                    "\t\t\t<br><br><br><br><br><br>\n" +
                    "\t\t\t<li>What is the level of BMI?</li>\n" +
                    "\t\t\t<p align=\"justify\">\n" +
                    "\t\t\t<table style=\"width:100%; border-spacing:0;margin-left:0px;\">\n" +
                    "\t\t\t<tr><th style = \"color : black\">BMI(kg/m<sup>2</sup>)</th><th style = \"color : black\">Classifications</th><th style = \"color : black\">Risk of Obesity</th></tr>\n" +
                    "\t\t\t<tr><td style=\"color:#1c1d26\">18.5-24.9</td><td style = \"color : #1c1d26\">Normal Range</td><td style = \"color : #1c1d26\">Negligible</td></tr>\n" +
                    "\t\t\t<tr><td style = \"color : #1c1d26\">25.0-29.9</td><td style = \"color : #1c1d26\">Overweight</td><td style = \"color : #1c1d26\"   >Mildly Increased</td></tr>\n" +
                    "\t\t\t<tr><td style = \"color : #1c1d26\">>30.0</td><td style = \"color : #1c1d26\">Obese</td><td style = \"color : #1c1d26\"></td></tr>\n" +
                    "\t\t\t<tr><td style = \"color : #1c1d26\">30.0-34.9</td><td style = \"color : #1c1d26\">Class I</td><td style = \"color : #1c1d26\">Moderate</td></tr>\n" +
                    "\t\t\t<tr><td style = \"color : #1c1d26\">35.0-34.9</td><td style = \"color : #1c1d26\">Class II</td><td style = \"color : #1c1d26\">Severe</td></tr>\n" +
                    "\t\t\t<tr><td style = \"color : #1c1d26\">>40.0</td><td style = \"color : #1c1d26\">Class III</td><td style = \"color : #1c1d26\">Very Severe</td></tr>\n"+
                    "\t\t\t</table></p>\n" +
                    "\t\t  </ul>\n" +
                    "\t\t <h1 id=\"bls\"><b style = \"color : #0d0d9a\">Blood Sugar (Diabetes):</b></h1>\n" +
                    "          <ul>\n" +
                    "\t\t    <li>What is Diabetes?</li>\n" +
                    "\t\t\t<p align=\"justify\">When the blood sugar increases due to deficiency of Insulin in blood, then the clinical syndromes are defined as diabetes.</p>\n" +
                    "            <li>What is symptoms of Diabetes?</li>\n" +
                    "\t\t\t<p align=\"justify\">-increased thirst and hunger.</p>\n" +
                    "\t\t\t<p align=\"justify\">-frequent urination.</p>\n" +
                    "\t\t\t<p align=\"justify\">-weight loss or gain that has no obvious cause.</p>\n" +
                    "\t\t\t<p align=\"justify\">-fatigue.</p>\n" +
                    "\t\t\t<p align=\"justify\">-blurred vision.</p>\n" +
                    "\t\t\t<p align=\"justify\">-wounds that heal slowly.</p>\n" +
                    "\t\t\t<p align=\"justify\">-skin infections.</p>\n" +
                    "\t\t\t<li> What is the normal level of blood sugar?</li>\n" +
                    "\t\t\t<p align=\"justify\">Normal plasma Glucose 3.5-6.1 mmol/L(65-110mg/dL)</p>\n" +
                    "            <li>When Diabetes can be detected?</li>\n" +
                    "\t\t\t<p align=\"justify\">If Blood Sugar is >= 7.0 mmol/L(before taking meal)</p>\n" +
                    "\t\t\t<p align=\"justify\">If Blood Sugar is >= 11.1 mmol/L(after taking meal)</p>\n" +
                    "            <li>What happens if blood sugar level decreases?</li>\n" +
                    "\t\t\t<p align=\"justify\">-Shakiness</p>\n" +
                    "\t\t\t<p align=\"justify\">-Nervousness or anxiety.</p>\n" +
                    "\t\t\t<p align=\"justify\">-Sweating, chills and clamminess.</p>\n" +
                    "\t\t\t<p align=\"justify\">-Irritability or impatience.</p>\n" +
                    "\t\t\t<p align=\"justify\">-Confusion, including delirium.</p>\n" +
                    "\t\t\t<p align=\"justify\">-Rapid/fast heartbeat.</p>\n" +
                    "\t\t\t<p align=\"justify\">-Lightheadedness or dizziness.</p>\n" +
                    "\t\t\t<p align=\"justify\">-Hunger.</p>\n" +
                    "            <li>What is the benefits of exercise?</li>\n" +
                    "\t\t\t<p align=\"justify\">-Controls Blood Pressure and Blood Sugar level.</p>\n" +
                    "\t\t\t<p align=\"justify\">-Helps to maintain ideal body weight and to lose extra weight.</p>\n" +
                    "\t\t\t<p align=\"justify\">-Increases blood supply to the body organs.</p>\n" +
                    "\t\t\t<li>Is there any harm if I do more exercise?</li>\n" +
                    "\t\t\t<p align=\"justify\">Yes, ofcourse. You have to be careful so that there is no chance of any kind of pain or injury. Exercise must be according to your body capability.</p>\n" +
                    "\t\t\t<li>When can't you do exercise?</li>\n" +
                    "\t\t\t<p align=\"justify\">If you have any heart disease, severe Nuropathy etc you shouldn't do hard exercise.</p>\n" +
                    "\t\t\t<li>How to control diabetes?</li>\n" +
                    "\t\t\t<p align=\"justify\"> You can control diabetes by 3 steps:</p>\n" +
                    "\t\t\t<p  align=\"justify\" style=\"margin-left:60px\">1. Proper diet</p>\n" +
                    "\t\t\t<p align=\"justify\" style=\"margin-left:60px\">2. Discipline</p>\n" +
                    "\t\t\t<p align=\"justify\" style=\"margin-left:60px\">3. Exercise</p>\n" +
                    "\t\t\t\n" +
                    "\t\t\t\n" +
                    "\t\t  </ul>\n" +
                    "\t\t \n" +
                    "\t\t  \n" +
                    "\t\t  \n" +
                    "        </div>\n" +
                    "\t\t</div>\n" +
                    "\t\t\n" + "</font>" +
                    "\t</div>" + "</body></html>";

            mWebView.getSettings();
            mWebView.setBackgroundColor(Color.TRANSPARENT);
            mWebView.loadData(text, "text/html", "utf-8");
        }
        else{

            String text = "<html><body>" +
                    "<div id=\"site_content\">\n" +
                    "        <div class=\"content\">\n" + "<font color=\"#1c1d26\">" +
                    "\t\t<div class=\"sidebar\" style=\"width:350px\">\n" +
                    "\t\t <h1 id=\"faqq\"><b style = \"color : purple\">&#x09B8;&#x099A;&#x09B0;&#x09BE;&#x099A;&#x09B0;&nbsp;&nbsp;&nbsp;&#x099C;&#x09BF;&#x099C;&#x09CD;&#x099E;&#x09BE;&#x09B8;&#x09CD;&#x09AF;</b></h1>\n" +
                    "\t\t <h1 id=\"blp\"><b style = \"color : #0d0d9a\">&#2480&#2453&#2509&#2468&#2458&#2494&#2474&#2435</b></h1>\n" +
                    "          <ul>\n" +
                    "\t\t\t<li>&#2480&#2453&#2509&#2468&#2458&#2494&#2474&#2503&#2480 &#2488&#2494&#2471&#2494&#2480&#2467 &#2482&#2503&#2477&#2503&#2482 &#2453&#2468&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">&#2474&#2509&#2480&#2494&#2474&#2509&#2468&#2476&#2527&#2488&#2509&#2453 &#2447&#2453&#2460&#2472 &#2478&#2494&#2472&#2497&#2487&#2503&#2480 &#2453&#2509&#2487&#2503&#2468&#2509&#2480&#2503&#44 &#2488&#2495&#2488&#2509&#2463&#2507&#2482&#2495&#2453&#45&#2465&#2494&#2527&#2494&#2488&#2509&#2463&#2507&#2482&#2495&#2453&#61 &#2542&#2534&#45&#2535&#2536&#2534&#2404 </p>\n" +
                    "\t\t\t<li>&#2488&#2495&#2488&#2509&#2463&#2507&#2482 &#2453&#2496&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\"> &#2489&#2499&#2470&#2488&#2509&#2474&#2472&#2509&#2470&#2472&#2503&#2480 &#2479&#2503&#2439 &#2470&#2486&#2494&#2527 &#2489&#2499&#2470&#2474&#2503&#2486&#2496  &#2488&#2434&#2453&#2497&#2458&#2495&#2468 &#2489&#2527 &#2447&#2476&#2434 &#2458&#2503&#2478&#2509&#2476&#2494&#2480 &#2469&#2503&#2453&#2503 &#2480&#2453&#2509&#2468 &#2471&#2478&#2472&#2496&#2468&#2503 &#2474&#2494&#2478&#2509&#2474 &#2453&#2480&#2503&#44 &#2468&#2494&#2453&#2503 &#2488&#2495&#2488&#2509&#2463&#2507&#2482 &#2476&#2482&#2503&#2404 </p> \n" +
                    "            <li>&#2465&#2494&#2527&#2494&#2488&#2509&#2463&#2507&#2482 &#2453&#2496&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">&#2489&#2499&#2470&#2488&#2509&#2474&#2472&#2509&#2470&#2472&#2503&#2480 &#2479&#2503&#2439 &#2470&#2486&#2494&#2527 &#2489&#2499&#2470&#2474&#2503&#2486&#2496 &#2474&#2509&#2480&#2488&#2494&#2480&#2495&#2468 &#2489&#2527 &#2447&#2476&#2434  &#2458&#2503&#2478&#2509&#2476&#2494&#2480&#2503 &#2480&#2453&#2509&#2468 &#2474&#2480&#2495&#2474&#2498&#2480&#2509&#2467 &#2453&#2480&#2503&#44 &#2468&#2494&#2453&#2503 &#2465&#2494&#2527&#2494&#2488&#2509&#2463&#2507&#2482 &#2476&#2482&#2503&#2404 </p>\n" +
                    "            \n" +
                    "\t\t\t</li>\n" +
                    "\t\t  </ul>\n" +
                    "\t\t <h1 id=\"pul\"><b style = \"color : #0d0d9a\">&#2489&#2499&#2470&#2488&#2509&#2474&#2472&#2509&#2470&#2472&#2435 </b></h1>\n" +
                    "          <ul>\n" +
                    "            <li>&#2489&#2499&#2470&#2488&#2509&#2474&#2472&#2509&#2470&#2472 &#2453&#2496&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">&#2489&#2499&#2470&#2488&#2509&#2474&#2472&#2509&#2470&#2472&#2503&#2480 &#2488&#2434&#2453&#2507&#2458&#2472 &#2447&#2476&#2434 &#2474&#2509&#2480&#2488&#2494&#2480&#2467&#2503&#2480 &#2488&#2478&#2527 &#2471&#2478&#2472&#2496&#2480 &#2477&#2495&#2468&#2480&#2503&#2480 &#2470&#2495&#2453&#2503 &#2458&#2494&#2474&#2503&#2480 &#2474&#2480&#2495&#2476&#2480&#2509&#2468&#2472&#2503&#2480 &#2475&#2482&#2503 &#2477&#2495&#2468&#2480&#2503&#2480 &#2470&#2495&#2453&#2503 &#2474&#2509&#2480&#2488&#2494&#2480&#2495&#2468 &#2489&#2527&#44 &#2447&#2453&#2503 &#2489&#2499&#2470&#2488&#2509&#2474&#2472&#2509&#2470&#2472 &#2476&#2482&#2503&#2404 </p>\n" +
                    "\t\t\t<li>&#2489&#2499&#2470&#2488&#2509&#2474&#2472&#2509&#2470&#2472&#2503&#2480 &#2488&#2494&#2471&#2494&#2480&#2467 &#2482&#2503&#2477&#2503&#2482 &#2453&#2468&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">&#2474&#2509&#2480&#2494&#2474&#2509&#2468&#2476&#2527&#2488&#2509&#2453&#2435 &#2540&#2534&#45&#2535&#2534&#2534 &#2488&#2509&#2474&#2472&#2509&#2470&#2472&#47&#2478&#2495&#2472&#2495&#2463 </p>\n" +
                    "\t\t\t<p align=\"justify\">&#2537 &#2476&#2459&#2480 &#2474&#2480&#2509&#2479&#2472&#2509&#2468&#2435 &#2535&#2534&#2534&#45&#2535&#2536&#2534 &#2488&#2509&#2474&#2472&#2509&#2470&#2472&#47&#2478&#2495&#2472&#2495&#2463</p>\n" +
                    "\t\t\t<p align=\"justify\">&#2537 &#2476&#2459&#2480&#2503&#2480 &#2441&#2480&#2509&#2471&#2476&#2503 &#2437&#2474&#2509&#2480&#2494&#2474&#2509&#2468&#2476&#2527&#2488&#2509&#2453&#2435 &#2542&#2534&#45&#2535&#2534&#2534 &#2488&#2509&#2474&#2472&#2509&#2470&#2472&#47&#2478&#2495&#2472&#2495&#2463</p>\n" +
                    "\t\t\t<li><u>&#2463&#2509&#2480&#2509&#2479&#2494&#2453&#2495&#2453&#2494&#2480&#2509&#2465&#2495&#2527&#2494</u> &#2453&#2496&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\"> &#2479&#2454&#2472 &#2489&#2499&#2470&#2488&#2509&#2474&#2472&#2509&#2470&#2472&#2503&#2480 &#2478&#2494&#2468&#2509&#2480&#2494 &#2535&#2534&#2534 &#2488&#2509&#2474&#2472&#2509&#2470&#2472&#47&#2478&#2495&#2472&#2495&#2463&#2503&#2480 &#2476&#2503&#2486&#2495 &#2468&#2454&#2472 &#2468&#2494&#2453&#2503 &#2463&#2509&#2480&#2494&#2453&#2495&#2453&#2494&#2480&#2509&#2465&#2495&#2527&#2494 &#2476&#2482&#2503&#2404</p>\n" +
                    "\t\t\t<li><u>&#2476&#2509&#2480&#2494&#2465&#2495&#2453&#2494&#2480&#2509&#2465&#2495&#2527&#2494</u> &#2453&#2496&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">&#2479&#2454&#2472 &#2489&#2499&#2470&#2488&#2509&#2474&#2472&#2509&#2470&#2472&#2503&#2480 &#2478&#2494&#2468&#2509&#2480&#2494 &#2540&#2534 &#2488&#2509&#2474&#2472&#2509&#2470&#2472&#47&#2478&#2495&#2472&#2495&#2463&#2503&#2480 &#2453&#2478 &#2468&#2454&#2472 &#2468&#2494&#2453&#2503 &#2476&#2509&#2480&#2494&#2465&#2495&#2453&#2494&#2480&#2509&#2465&#2495&#2527&#2494 &#2476&#2482&#2503&#2404 </p>\n" +
                    "\t\t\t</ul>\n" +
                    "\t\t <h1 id=\"bm\"><b style = \"color : #0d0d9a\">&#2476&#2465&#2495 &#2478&#2494&#2488 &#2439&#2472&#2465&#2503&#2453&#2509&#2488&#2435 </b></h1>\n" +
                    "         <ul>\n" +
                    "\t\t    <li>&#2453&#2496&#2477&#2494&#2476&#2503 &#2476&#2495&#2447&#2478&#2438&#2439 &#2474&#2480&#2495&#2478&#2494&#2474 &#2453&#2480&#2494 &#2479&#2494&#2527&#63</li>\n" +
                    "\t\t\t<p align=\"justify\"><div style=\"float:left;margin-top:20px;margin-left:25px;color:#1c1d26\">&#2476&#2495&#2447&#2478&#2438&#2439= &nbsp;</div>\n" +
                    "\t\t\t<div style=\"float:left\">\n" +
                    "\t\t\t<div style=\"border-bottom:1px solid;font-size:20px;text-align:center;color:#1c1d26\">&#2438&#2474&#2472&#2494&#2480 &#2451&#2460&#2472&#40&#2453&#2503&#2460&#2495&#41 </div>\n" +
                    "\t\t\t<div style=\"font-size:20px;text-align:center;margin-bottom:20px;color:#1c1d26\">&#2438&#2474&#2472&#2494&#2480 &#2441&#2458&#2509&#2458&#2468&#2494&#40&#2478&#2495&#2463&#2494&#2480&#41 <sup>&#2536 </sup></div>\n" +
                    "\t\t\t</div></p>\n" +
                    "\t\t\t<br><br><br><br><br><br>\n" +
                    "\t\t\t<li>&#2476&#2495&#2447&#2478&#2438&#2439 &#2447&#2480 &#2482&#2503&#2477&#2503&#2482 &#2453&#2468&#63</li>\n" +
                    "\t\t\t<p align=\"justify\">\n" +
                    "\t\t\t<table style=\"width:100%; border-spacing:0;margin-left:0px;\">\n" +
                    "\t\t\t<tr><th>&#2476&#2495&#2447&#2478&#2438&#2439&#40&#2453&#2503&#2460&#2495&#47&#2478&#2495&#2463&#2494&#2480  <sup>&#2536 </sup>&#41 </th><th>&#2486&#2509&#2480&#2503&#2467&#2496&#2476&#2495&#2477&#2494&#2455 </th><th>&#2488&#2509&#2469&#2498&#2482&#2468&#2494&#2480 &#2461&#2497&#2433&#2453&#2495 </th></tr>\n" +
                    "\t\t\t<tr><td>&#2535&#2542&#46&#2539&#45&#2536&#2538&#46&#2543 </td><td>&#2488&#2494&#2471&#2494&#2480&#2467 &#2488&#2496&#2478&#2494 </td><td>&#2441&#2474&#2503&#2453&#2509&#2487&#2467&#2496&#2527</td></tr>\n" +
                    "\t\t\t<tr><td>&#2536&#2539&#46&#2534&#45&#2536&#2543&#46&#2543 </td><td>&#2478&#2494&#2468&#2509&#2480&#2494&#2468&#2495&#2480&#2495&#2453&#2509&#2468 &#2451&#2460&#2472 </td><td>&#2488&#2494&#2478&#2494&#2472&#2509&#2479 &#2476&#2503&#2486&#2495 </td></tr>\n" +
                    "\t\t\t<tr><td>&#62&#2537&#2534&#46&#2534 </td><td>&#2488&#2509&#2469&#2498&#2482&#2453&#2494&#2527 </td><td></td></tr>\n" +
                    "\t\t\t<tr><td>&#2537&#2534&#46&#2534&#45&#2537&#2538&#46&#2543 </td><td>&#2486&#2509&#2480&#2503&#2467&#2496&#45&#2534&#2535 </td><td>&#2474&#2480&#2495&#2478&#2495&#2468 </td></tr>\n" +
                    "\t\t\t<tr><td>&#2537&#2539&#46&#2534&#45&#2537&#2543&#46&#2543 </td><td>&#2486&#2509&#2480&#2503&#2467&#2496&#45&#2534&#2536 </td><td>&#2468&#2496&#2476&#2509&#2480 </td></tr>\n" +
                    "\t\t\t<tr><td>&#62&#2538&#2534&#46&#2534 </td><td>&#2486&#2509&#2480&#2503&#2467&#2496&#45&#2534&#2537 </td><td>&#2437&#2468&#2495&#2468&#2496&#2476&#2509&#2480 </td></tr>\n" +
                    "\t\t\t</table></p>\n" +
                    "\t\t  </ul>\n" +
                    "\t\t <h1 id=\"bls\"><b style = \"color : #0d0d9a\">&#2476&#2509&#2482&#2494&#2465 &#2488&#2497&#2455&#2494&#2480&#40&#2465&#2494&#2527&#2494&#2476&#2503&#2463&#2495&#2488&#41&#58 </b></h1>\n" +
                    "          <ul>\n" +
                    "\t\t    <li>&#2465&#2494&#2527&#2494&#2476&#2503&#2463&#2495&#2488 &#2453&#2496&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">&#2439&#2472&#2488&#2497&#2482&#2495&#2472&#2503&#2480 &#2456&#2494&#2463&#2468&#2495&#2480 &#2453&#2494&#2480&#2467&#2503 &#2480&#2453&#2509&#2468&#2503 &#2486&#2480&#2509&#2453&#2480&#2494&#2480 &#2474&#2480&#2495&#2478&#2494&#2467 &#2476&#2503&#2524&#2503 &#2455&#2503&#2482&#2503 &#2458&#2495&#2453&#2495&#2510&#2488&#2494&#2476&#2495&#2470&#2509&#2479&#2494 &#2478&#2468&#2503 &#2447&#2439 &#2437&#2476&#2488&#2509&#2469&#2494&#2453&#2503 &#2465&#2494&#2527&#2494&#2476&#2503&#2463&#2495&#2488 &#2476&#2482&#2503&#2404 </p>\n" +
                    "            <li>&#2465&#2494&#2527&#2494&#2476&#2503&#2463&#2495&#2488 &#2447&#2480 &#2482&#2453&#2509&#2487&#2467 &#2453&#2496 &#2453&#2496&#63</li>\n" +
                    "\t\t\t<p align=\"justify\">-&#2456&#2472 &#2456&#2472 &#2468&#2499&#2487&#2509&#2467&#2494 &#2474&#2494&#2451&#2527&#2494 </p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2456&#2472 &#2456&#2472 &#2474&#2509&#2480&#2488&#2509&#2480&#2494&#2476 &#2489&#2451&#2527&#2494 </p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2476&#2494&#2480 &#2476&#2494&#2480 &#2453&#2509&#2487&#2497&#2471&#2494 &#2482&#2494&#2455&#2494 </p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2451&#2460&#2472 &#2453&#2478&#2503 &#2479&#2494&#2451&#2527&#2494 </p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2458&#2507&#2454&#2503 &#2461&#2494&#2474&#2488&#2494 &#2470&#2503&#2454&#2494 </p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2453&#2509&#2487&#2468&#2488&#2509&#2469&#2494&#2472 &#2486&#2497&#2453&#2494&#2468&#2503 &#2470&#2503&#2480&#2495 &#2489&#2451&#2527&#2494 </p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2470&#2498&#2480&#2509&#2476&#2482&#2468&#2494 </p>\n" +
                    "\t\t\t<li> &#2476&#2509&#2482&#2494&#2465 &#2488&#2497&#2455&#2494&#2480&#2503&#2480 &#2488&#2494&#2471&#2494&#2480&#2467 &#2482&#2503&#2477&#2503&#2482 &#2453&#2468&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">&#2537&#46&#2539&#45&#2540&#46&#2535 &#2478&#2495&#2482&#2495&#2478&#2507&#2482&#47&#2482&#2495&#2463&#2494&#2480 </p>\n" +
                    "\t\t\t<li>&#2453&#2496&#2477&#2494&#2476&#2503 &#2476&#2507&#2461&#2494 &#2479&#2494&#2476&#2503 &#2465&#2494&#2527&#2494&#2476&#2503&#2463&#2495&#2488&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">&#2454&#2494&#2476&#2494&#2480 &#2438&#2455&#2503 &#2476&#2509&#2482&#2494&#2465 &#2488&#2497&#2455&#2494&#2480&#62&#61&#2541&#46&#2534 &#2478&#2495&#2482&#2495&#2478&#2507&#2482&#47&#2482&#2495&#2463&#2494&#2480 </p>\n" +
                    "            <p>&#2454&#2494&#2476&#2494&#2480 &#2470&#2497&#2439 &#2456&#2472&#2509&#2463&#2494 &#2474&#2480 &#2476&#2509&#2482&#2494&#2465 &#2488&#2497&#2455&#2494&#2480&#62&#61&#2535&#2535&#46&#2534 &#2478&#2495&#2482&#2495&#2478&#2507&#2482&#47&#2482&#2495&#2463&#2494&#2480 </p>\n" +
                    "            <li>&#2476&#2509&#2482&#2494&#2465 &#2488&#2497&#2455&#2494&#2480 &#2482&#2503&#2477&#2503&#2482 &#2453&#2478&#2503 &#2455&#2503&#2482&#2503 &#2453&#2496 &#2489&#2476&#2503&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">-&#2437&#2472&#2503&#2453 &#2476&#2503&#2486&#2495 &#2456&#2494&#2478 &#2489&#2527</p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2486&#2480&#2496&#2480&#2503 &#2453&#2478&#2509&#2474&#2472&#2503&#2480 &#2478&#2468 &#2489&#2527 </p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2437&#2472&#2503&#2453 &#2453&#2509&#2487&#2497&#2471&#2494 &#2482&#2494&#2455&#2503 </p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2437&#2488&#2509&#2469&#2495&#2480&#2468&#2494 </p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2470&#2498&#2480&#2509&#2476&#2482&#2468&#2494 </p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2478&#2494&#2469&#2494&#2476&#2509&#2479&#2494&#2469&#2494 </p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2476&#2478&#2495 &#2476&#2478&#2495 &#2477&#2494&#2476 </p>\n" +
                    "            <li>&#2486&#2480&#2496&#2480&#2458&#2480&#2509&#2458&#2494&#2480 &#2441&#2474&#2453&#2494&#2480&#2495&#2468&#2494 &#2453&#2496&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">-&#2480&#2453&#2509&#2468&#2458&#2494&#2474 &#2447&#2476&#2434 &#2476&#2509&#2482&#2494&#2465 &#2488&#2497&#2455&#2494&#2480&#2503&#2480 &#2478&#2494&#2468&#2509&#2480&#2494 &#2464&#2495&#2453 &#2480&#2494&#2454&#2503 </p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2488&#2464&#2495&#2453 &#2451&#2460&#2472 &#2447&#2476&#2434 &#2476&#2494&#2524&#2468&#2495 &#2478&#2503&#2470 &#2461&#2524&#2494&#2468&#2503 &#2488&#2494&#2489&#2494&#2479&#2509&#2479 &#2453&#2480&#2503</p>\n" +
                    "\t\t\t<p align=\"justify\">-&#2486&#2480&#2496&#2480&#2503&#2480 &#2488&#2453&#2482 &#2437&#2434&#2486&#2503 &#2480&#2453&#2509&#2468 &#2488&#2462&#2509&#2458&#2494&#2482&#2472 &#2476&#2494&#2524&#2494&#2527 </p>\n" +
                    "\t\t\t<li>&#2437&#2471&#2495&#2453 &#2486&#2480&#2496&#2480&#2458&#2480&#2509&#2458&#2494 &#2453&#2496 &#2453&#2507&#2472 &#2453&#2509&#2487&#2468&#2495&#2488&#2494&#2471&#2472 &#2453&#2480&#2503&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">&#2437&#2476&#2486&#2509&#2479&#2439&#2404 &#2454&#2503&#2527&#2494&#2482 &#2480&#2494&#2454&#2468&#2503 &#2489&#2476&#2503 &#2486&#2480&#2496&#2480&#2458&#2480&#2509&#2458&#2494&#2479&#2503&#2472 &#2453&#2507&#2472&#2477&#2494&#2476&#2503&#2439 &#2453&#2507&#2472 &#2476&#2509&#2479&#2494&#2469&#2494 &#2476&#2494 &#2453&#2509&#2487&#2468&#2495&#2480 &#2453&#2494&#2480&#2467 &#2472&#2494 &#2489&#2527&#2404 &#2474&#2509&#2480&#2468&#2509&#2479&#2503&#2453&#2503&#2480 &#2486&#2480&#2496&#2480&#2503&#2480 &#2488&#2494&#2471&#2509&#2479&#2494&#2472&#2497&#2479&#2494&#2527&#2496 &#2476&#2509&#2479&#2494&#2527&#2494&#2478 &#2453&#2480&#2494 &#2441&#2458&#2495&#2468&#2404</p>\n" +
                    "\t\t\t<li>&#2453&#2454&#2472 &#2476&#2509&#2479&#2494&#2527&#2494&#2478 &#2453&#2480&#2494 &#2441&#2458&#2495&#2468 &#2472&#2527&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">&#2479&#2470&#2495 &#2438&#2474&#2472&#2494&#2480 &#2489&#2499&#2470&#2480&#2507&#2455 &#2469&#2494&#2453&#2503 &#2468&#2494&#2489&#2482&#2503 &#2453&#2464&#2495&#2472 &#2476&#2509&#2479&#2494&#2527&#2494&#2478 &#2469&#2503&#2453&#2503 &#2476&#2495&#2480&#2468 &#2469&#2494&#2453&#2494 &#2441&#2458&#2495&#2468&#2404 </p>\n" +
                    "\t\t\t<li>&#2453&#2496&#2477&#2494&#2476&#2503 &#2465&#2494&#2527&#2494&#2476&#2503&#2463&#2495&#2488 &#2472&#2495&#2527&#2472&#2509&#2468&#2509&#2480&#2467&#2503 &#2480&#2494&#2454&#2494 &#2479&#2494&#2527&#63 </li>\n" +
                    "\t\t\t<p align=\"justify\">&#2465&#2494&#2527&#2494&#2476&#2503&#2463&#2495&#2488 &#2468&#2495&#2472&#2463&#2495 &#2488&#2489&#2460 &#2441&#2474&#2494&#2527&#2503 &#2472&#2495&#2527&#2472&#2509&#2468&#2509&#2480&#2467&#2503 &#2480&#2494&#2454&#2494 &#2479&#2494&#2527&#2435 </p>\n" +
                    "\t\t\t<p style=\"margin-left:60px\">&#2535&#2404 &#2474&#2480&#2495&#2478&#2495&#2468 &#2451 &#2488&#2464&#2495&#2453 &#2454&#2494&#2476&#2494&#2480 </p>\n" +
                    "\t\t\t<p style=\"margin-left:60px\">&#2536&#2404 &#2472&#2495&#2527&#2478&#2494&#2472&#2497&#2476&#2480&#2509&#2468&#2495&#2468&#2494 </p>\n" +
                    "\t\t\t<p style=\"margin-left:60px\">&#2537&#2404 &#2476&#2509&#2479&#2494&#2527&#2494&#2478 </p>\n" +
                    "\t\t\t\n" +
                    "\t\t\t\n" +
                    "\t\t  </ul>\n" +
                    "\t\t \n" +
                    "\t\t  \n" +
                    "\t\t  \n" +
                    "        </div>\n"+
                    "\t\t</div>\n" +
                    "\t\t\n" + "</font>" +
                    "\t</div>" + "</body></html>";


            mWebView.getSettings();
            mWebView.setBackgroundColor(Color.TRANSPARENT);
            mWebView.loadData(text, "text/html", "utf-8");
        }
    }
}
