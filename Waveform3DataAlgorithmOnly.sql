--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.12
-- Dumped by pg_dump version 9.1.12
-- Started on 2014-06-13 17:02:40 EDT

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 2866 (class 0 OID 36872)
-- Dependencies: 177 2873
-- Data for Name: service; Type: TABLE DATA; Schema: public; Owner: liferay
--

COPY service (serviceid, "uiName", "wsName", "wsUrl") FROM stdin;
1	LocalPhysionet	physionetAnalysisService	http://localhost:8080/axis2/services
2	icmv058	physionetAnalysisService	http://128.220.76.170:8080/axis2/services
3	QRS_Score	qrs_scoreAnalysisService	http://localhost:8080/axis2/services
\.


--
-- TOC entry 2850 (class 0 OID 36791)
-- Dependencies: 161 2866 2873
-- Data for Name: algorithm; Type: TABLE DATA; Schema: public; Owner: liferay
--

COPY algorithm (serviceid, "uiName", "shortDescription", "completeDescription", "serviceMethod", algorithmid, resultformat) FROM stdin;
1	sqrs2csv	Attempts to locate QRS complexes in an ECG signal in the specified record. The detector algorithm is based on the length transform. Reads the ann...	Attempts to locate QRS complexes in an ECG signal in the specified record. The detector algorithm is based on the length transform. Reads the annotation file specified by record and annotator and writes a comma-separated-value format translation of it, one annotation per line.	sqrs2csvWrapperType2	49	CSV
1	QT Screening	Chesnokov's QT Screening algorithm.	This program analyses a WFDB formatted ECG file and finds Total Beat count, Ectopic Beat count, Corrected QT Interval, Log of the QTV. It also finds the Interval Count, Mean Interval, Variance and Standard Deviation for both RR and QT intervals.  Original code at: http://www.codeproject.com/Articles/20995/ECG-Annotation-C-Library	chesnokovWrapperType2	45	TabDelimitedText
1	rdsamp	reads a WFDB file and writes it in human readable format	rdsamp reads signal files for the specified record and writes the samples \nas decimal numbers on the standard output. If no options are provided, \nrdsamp starts at the beginning of the record and prints all samples. \nBy default, each line of output contains the sample number and samples \nfrom each signal, beginning with channel 0, separated by tabs.	rdsampWrapperType2	46	TabDelimitedText
1	sigamp	Measure signal amplitudes of a WFDB record.	sigamp measures either baseline-corrected RMS amplitudes or (for suitably annotated ECG signals)  \n normal QRS peak-to-peak amplitudes for all signals of the specified record.  \n It makes up to 300 measurements (but see -n below) for each signal and calculates trimmed means  \n (by discarding the largest and smallest 5% of the measurements and taking the mean of the remaining 90%).	sigampWrapperType2	47	TabDelimitedText
2	sqrs	Single-channel QRS detector.	sqrs attempts to locate QRS complexes in an ECG signal in the specified record. The detector algorithm is based on example 10 in the WFDB Programmer's Guide, which in turn is based on a Pascal program written by W.A.H. Engelse and C. Zeelenberg, "A single scan algorithm for QRS-detection and feature extraction", Computers in Cardiology 6:37-42 (1979). sqrs does not include the feature extraction capability of the Pascal program. The output of sqrs is an annotation file (with annotator name qrs) in which all detected beats are labelled normal; the annotation file may also contain "artifact" annotations at locations that sqrs believes are noise-corrupted.\n sqrs can process records containing any number of signals, but it uses only one signal for QRS detection (signal 0 by default; this can be changed using the -s option, see below). sqrs is optimized for use with adult human ECGs. For other ECGs, it may be necessary to experiment with the sampling frequency as recorded in the input record's header file (see header(5) ) and the time constants indicated in the source file.\n sqrs uses the WFDB library's setifreq function to resample the input signal at 250 Hz if a significantly different sampling frequency is indicated in the header file. sqrs125 is identical to sqrs except that its filter and time constants have been designed for 125 Hz input, so that its speed is roughly twice that of sqrs. If the input signal has been sampled at a frequency near 125 Hz, the quality of the outputs of sqrs and sqrs125 will be nearly identical. (Note that older versions of these programs did not resample their inputs; rather, they warned if the sampling frequency was significantly different than the ideal frequency, and suggested using xform(1) to resample the input.)\n This program is provided as an example only, and is not intended for any clinical application. At the time the algorithm was originally published, its performance was typical of state-of-the-art QRS detectors. Recent designs, particularly those that can analyze two or more input signals, may exhibit significantly better performance.	sqrsWrapperType2	48	WFDBAnnotation
1	wqrs2csv	Attempts to locate QRS complexes in an ECG signal in the specified record and reads the annotation file specified by record and annotator and wri...	Attempts to locate QRS complexes in an ECG signal in the specified record and reads the annotation file specified by record and annotator and writes a comma-separated-value format translation of it, one annotation per line.	wqrs2csvWrapperType2	53	CSV
1	sqrs4ihr	Produces an instantaneous heart rate signal from a Single-channel QRS detector.	Produces an instantaneous heart rate signal from a Single-channel QRS detector (from the reciprocals of the interbeat intervals.) Unlike tach(1) , however, ihr does not resample its output in order to obtain uniform time intervals between output samples. (If there is any variation whatsoever in heart rate, the intervals between output samples will be non-uniform.) This property makes the output of ihr unsuitable for conventional power spectral density estimation, but ideal for PSD estimation using the Lomb periodogram (see lomb(1) ).	sqrs4ihrWrapperType2	50	CSV
1	sqrs4pnnlist/pNNx	Calculates time domain measures of heart rate variability from a Single-channel QRS detector.	Calculates time domain measures of heart rate variability from a Single-channel QRS detector (from the reciprocals of the interbeat intervals). These programs derive pNNx, time domain measures of heart rate variability defined for any time interval x as the fraction of consecutive normal sinus (NN) intervals that differ by more than x.Conventionally, such measures have been applied to assess parasympathetic activity using x = 50 milliseconds (yielding the widely-cited pNN50 statistic).	sqrs4pnnlistWrapperType2	51	CSV
1	wqrs4pnnlist/pNNx	Calculates time domain measures of heart rate variability from a Single-channel QRS detector.	Calculates time domain measures of heart rate variability from a Single-channel QRS detector (from the reciprocals of the interbeat intervals). These programs derive pNNx, time domain measures of heart rate variability defined for any time interval x as the fraction of consecutive normal sinus (NN) intervals that differ by more than x.Conventionally, such measures have been applied to assess parasympathetic activity using x = 50 milliseconds (yielding the widely-cited pNN50 statistic).	wqrs4pnnlistWrapperType2	55	CSV
1	wqrs	single-channel QRS detector based on length transform.	wqrs attempts to locate QRS complexes in an ECG signal in the specified record. The detector algorithm is based on the length transform. The output of wqrs is an annotation file (with annotator name wqrs) in which all detected beats are labelled normal; the annotation file will also contain optional J-point annotations if the -j option (see below) is used. \n wqrs can process records containing any number of signals, but it uses only one signal for QRS detection (signal 0 by default; this can be changed using the -s option, see below). wqrs is optimized for use with adult human ECGs. For other ECGs, it may be necessary to experiment with the sampling frequency as recorded in the input record's header file (see header(5) ), the detector threshold (which can be set using the -m option), and the time constants indicated in the source file. \n wqrs optionally uses the WFDB library's setifreq function to resample the input signal at 120 or 150 Hz (depending on the mains frequency, which can be specified using the -p option). wqrs performs well using input sampled at a range of rates up to 360 Hz and possibly higher rates, but it has been designed and tested to work best on signals sampled at 120 or 150 Hz.	wqrsWrapperType2	52	WFDBAnnotation
3	QRS-Score	Strauss-Selvester QRS-Score	Strauss-Selvester QRS-Score	qrs_scoreWrapperType2	56	CSV
1	wqrs4ihr	Produces an instantaneous heart rate signal from a Single-channel QRS detector.	Produces an instantaneous heart rate signal from a Single-channel QRS detector (from the reciprocals of the interbeat intervals.) Unlike tach(1) , however, ihr does not resample its output in order to obtain uniform time intervals between output samples. (If there is any variation whatsoever in heart rate, the intervals between output samples will be non-uniform.) This property makes the output of ihr unsuitable for conventional power spectral density estimation, but ideal for PSD estimation using the Lomb periodogram (see lomb(1) ).	wqrs4ihrWrapperType2	54	CSV
\.


--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 182
-- Name: algorithmReference_algorithmReferenceID_seq; Type: SEQUENCE SET; Schema: public; Owner: liferay
--

SELECT pg_catalog.setval('"algorithmReference_algorithmReferenceID_seq"', 14, true);


--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 163
-- Name: algorithm_algorithmid_seq; Type: SEQUENCE SET; Schema: public; Owner: liferay
--

SELECT pg_catalog.setval('algorithm_algorithmid_seq', 56, true);


--
-- TOC entry 2864 (class 0 OID 36867)
-- Dependencies: 175 2873
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: liferay
--

COPY person (firstname, lastname, middlename, email, phonenumber, "personID") FROM stdin;
\.


--
-- TOC entry 2851 (class 0 OID 36797)
-- Dependencies: 162 2850 2864 2873
-- Data for Name: algorithmperson; Type: TABLE DATA; Schema: public; Owner: liferay
--

COPY algorithmperson (algorithmid, personid, "algorithmPersonid") FROM stdin;
\.


--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 164
-- Name: algorithmperson_algorithmpersonid_seq; Type: SEQUENCE SET; Schema: public; Owner: liferay
--

SELECT pg_catalog.setval('algorithmperson_algorithmpersonid_seq', 1, false);


--
-- TOC entry 2870 (class 0 OID 37240)
-- Dependencies: 181 2850 2873
-- Data for Name: algorithmreference; Type: TABLE DATA; Schema: public; Owner: liferay
--

COPY algorithmreference (algorithmreferenceid, algorithmid, "versionAlgorithm", "dateAlgorithm", "versionWebService", "dateWebService", licence, referenceurl) FROM stdin;
1	45	n/a	\N	n/a	\N	n/a	http://wiki.cvrgrid.org/index.php/ECG_Gadget_User_Guide#QT_Screening_Algorithm_Results_File_Example
3	46	n/a	\N	2.0	2012-12-04	http://physionet.org/physiotools/wag/wag.htm	http://www.physionet.org/physiotools/wag/sigamp-1.htm
4	47	n/a	\N	2.0	2012-12-04	http://physionet.org/physiotools/wag/wag.htm	http://www.physionet.org/physiotools/wag/sigamp-1.htm
5	48	n/a	\N	2.0	2012-11-16	http://physionet.org/physiotools/wag/wag.htm	http://www.physionet.org/physiotools/wag/sqrs-1.htm
6	50	n/a	\N	2.0	2014-02-10	http://physionet.org/physiotools/wag/wag.htm	http://www.physionet.org/physiotools/wag/ihr-1.htm
8	49	n/a	\N	2.0	2014-02-03	http://physionet.org/physiotools/wag/wag.htm	http://www.physionet.org/physiotools/wag/sqrs-1.htm
9	51	n/a	\N	2.0	2014-02-10	http://physionet.org/physiotools/wag/wag.htm	http://physionet.org/physiotools/wag/pnnlis-1.htm
10	52	n/a	\N	2.0	2012-12-03	http://physionet.org/physiotools/wag/wag.htm	http://www.physionet.org/physiotools/wag/wqrs-1.htm
11	53	n/a	\N	2.0	2014-02-03	http://physionet.org/physiotools/wag/wag.htm	http://www.physionet.org/physiotools/wag/wqrs-1.htm
12	54	n/a	\N	2.0	2014-02-10	http://physionet.org/physiotools/wag/wag.htm	http://www.physionet.org/physiotools/wag/ihr-1.htm
13	55	n/a	\N	2.0	2014-02-10	http://physionet.org/physiotools/wag/wag.htm	http://physionet.org/physiotools/wag/pnnlis-1.htm
14	56	n/a	\N	n/a	\N	n/a	n/a
\.


--
-- TOC entry 2872 (class 0 OID 37284)
-- Dependencies: 184 2873
-- Data for Name: analysisjob; Type: TABLE DATA; Schema: public; Owner: liferay
--

COPY analysisjob (analysisjobid, filecount, documentrecordid, parametercount, serviceurl, servicename, servicemethod, userid, dateofanalysis) FROM stdin;
1	1	1967	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-15 20:15:08.374
2	2	1967	0	http://128.220.76.170:8080/axis2/services	physionetAnalysisService	sqrsWrapperType2	10195	2014-05-16 15:20:41.144
3	2	1967	0	http://localhost:8080/axis2/services	physionetAnalysisService	sigampWrapperType2	10195	2014-05-16 15:50:35.83
4	2	1967	0	http://localhost:8080/axis2/services	physionetAnalysisService	sqrs2csvWrapperType2	10195	2014-05-16 17:56:46.005
5	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	rdsampWrapperType2	10195	2014-05-19 20:31:41.679
6	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	rdsampWrapperType2	10195	2014-05-19 21:00:36.113
7	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-19 21:06:41.798
8	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-19 21:18:20.659
9	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-19 21:43:28.083
10	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-20 13:27:20.642
11	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-20 13:38:51.439
12	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrs2csvWrapperType2	10195	2014-05-20 14:57:25.617
13	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-20 15:04:08.859
14	2	1968	0	http://localhost:8080/axis2/services	physionetAnalysisService	sigampWrapperType2	10195	2014-05-20 15:11:28.575
15	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-20 16:53:40.946
16	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-20 19:23:19.923
17	2	1971	0	http://128.220.76.170:8080/axis2/services	physionetAnalysisService	sqrsWrapperType2	10195	2014-05-20 19:39:53.133
18	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrs2csvWrapperType2	10195	2014-05-20 21:02:23.325
19	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	sigampWrapperType2	10195	2014-05-20 21:11:08.549
20	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-21 13:38:30.069
21	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-21 14:00:51.208
22	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-21 16:07:39.316
23	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-21 16:08:01.323
24	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	sigampWrapperType2	10195	2014-05-21 16:31:41.105
25	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	sigampWrapperType2	10195	2014-05-21 17:10:29.9
26	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	rdsampWrapperType2	10195	2014-05-21 17:19:26.142
27	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	rdsampWrapperType2	10195	2014-05-21 18:31:52.306
28	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-21 18:34:59.309
29	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	wqrsWrapperType2	10195	2014-05-27 21:43:36.412
30	2	1971	0	http://localhost:8080/axis2/services	physionetAnalysisService	qrs_scoreWrapperType2	10195	2014-05-30 17:15:36.3
31	2	1968	0	http://localhost:8080/axis2/services	physionetAnalysisService	qrs_scoreWrapperType2	10195	2014-05-30 18:22:02.179
32	2	1968	0	http://localhost:8080/axis2/services	physionetAnalysisService	qrs_scoreWrapperType2	10195	2014-05-30 18:36:05.98
33	2	1968	0	http://localhost:8080/axis2/services	physionetAnalysisService	qrs_scoreWrapperType2	10195	2014-05-30 18:36:41.153
34	2	1966	0	http://localhost:8080/axis2/services	physionetAnalysisService	qrs_scoreWrapperType2	10195	2014-05-30 18:39:38.651
35	2	1966	0	http://localhost:8080/axis2/services	physionetAnalysisService	qrs_scoreWrapperType2	10195	2014-05-30 19:46:02.693
36	2	1966	0	http://localhost:8080/axis2/services	physionetAnalysisService	qrs_scoreWrapperType2	10195	2014-05-30 20:06:36.453
37	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-02 16:46:50.299
38	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-02 18:51:02.621
39	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-02 18:58:21.041
40	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-02 20:47:52.149
41	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-02 21:06:25.837
42	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-02 21:07:04.584
43	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 14:10:22.103
44	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 16:42:48.268
45	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 16:51:32.363
46	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 17:04:26.302
47	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 17:31:36.914
48	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 18:12:29.387
49	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 18:59:43.088
50	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 19:00:17.771
51	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 19:07:34.729
52	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 19:50:55.682
53	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 20:11:21.588
54	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 20:19:35.409
55	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 20:30:42.571
56	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-03 21:01:59.791
57	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 16:09:51.561
58	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 16:27:30.318
59	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 16:47:52.193
60	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 16:58:43.122
61	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 17:02:55.896
62	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 17:07:59.78
63	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 17:18:03.465
64	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 17:22:44.528
65	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 18:25:06.558
66	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 18:59:21.37
67	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 19:19:06.611
68	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 19:22:42.251
69	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 20:26:19.322
70	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 20:28:59.986
71	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 20:57:42.58
72	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-05 21:15:52.997
73	2	1966	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-06 18:50:46.716
74	2	1977	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 16:05:14.131
75	2	1977	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:01:04.937
76	2	1977	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:23:15.438
77	2	1977	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:28:53.128
78	2	1977	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:42:48.531
79	2	1977	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:52:18.462
80	2	1979	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:52:18.608
81	2	1978	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:52:18.756
82	2	1980	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:52:18.893
83	2	1981	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:52:19.04
84	2	1979	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:52:48.197
85	2	1978	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:52:48.325
86	2	1980	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:52:48.462
87	2	1981	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:52:48.608
88	2	1979	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:57:10.482
89	2	1979	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 18:57:26.576
90	2	1978	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-10 19:55:31.709
91	2	1982	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-11 13:18:40.933
92	2	1982	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-11 14:59:17.185
93	2	1982	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-11 15:53:13.004
94	2	1982	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-11 16:27:43.593
95	2	1982	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-11 21:04:43.284
96	2	1983	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-11 21:07:35.48
97	2	1984	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-11 21:08:17.436
98	2	1985	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-11 21:08:39.611
99	2	1986	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-11 21:08:55.382
100	2	1982	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-12 17:28:29.25
101	2	1983	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-12 18:32:50.481
102	2	1984	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-12 18:32:50.727
103	2	1985	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-12 18:32:50.871
104	2	1986	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-12 18:32:51.022
105	2	1982	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-12 21:07:43.27
106	2	1982	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-13 13:22:46.065
107	2	1983	0	http://localhost:8080/axis2/services	qrs_scoreAnalysisService	qrs_scoreWrapperType2	10195	2014-06-13 20:37:54.552
\.


--
-- TOC entry 2854 (class 0 OID 36830)
-- Dependencies: 165 2873
-- Data for Name: organization; Type: TABLE DATA; Schema: public; Owner: liferay
--

COPY organization ("uiName", "organizationID", "orgUrl", phonenumber) FROM stdin;
\.


--
-- TOC entry 2855 (class 0 OID 36836)
-- Dependencies: 166 2854 2864 2873
-- Data for Name: organizationContact; Type: TABLE DATA; Schema: public; Owner: liferay
--

COPY "organizationContact" ("organizationContactID", "organizationID", "contactID") FROM stdin;
\.


--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 167
-- Name: organization_organizationid_seq; Type: SEQUENCE SET; Schema: public; Owner: liferay
--

SELECT pg_catalog.setval('organization_organizationid_seq', 1, false);


--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 168
-- Name: organizationcontact_organizationcontactid_seq; Type: SEQUENCE SET; Schema: public; Owner: liferay
--

SELECT pg_catalog.setval('organizationcontact_organizationcontactid_seq', 1, false);


--
-- TOC entry 2860 (class 0 OID 36858)
-- Dependencies: 171 2873
-- Data for Name: parameterType; Type: TABLE DATA; Schema: public; Owner: liferay
--

COPY "parameterType" ("parameterTypeid", "uiName", "shortDescription") FROM stdin;
1	text	Can take on any text value.
2	integer	Takes only an integer number value.
3	float	Takes a real number value.
4	boolean	Takes a true or false, e.g. a checkbox, true=checked
5	select	Takes on one (or many) or a specific set of values. Requires a Parameter Option list below.
6	drill down	Takes on one (or many) of a specific set of values. Creating a hierarchical select menu, which allows users to "drill down" a set of options.
\.


--
-- TOC entry 2858 (class 0 OID 36843)
-- Dependencies: 169 2850 2860 2873
-- Data for Name: parameter; Type: TABLE DATA; Schema: public; Owner: liferay
--

COPY parameter (parameterid, algorithmid, "uiName", "shortDescription", "completeDescription", flag, "defaultValue", "parameterTypeid", required, "multipleSelect", "parameterValidationid") FROM stdin;
336	46	Begin time(seconds)	Begin time(seconds)	Begin at the specified time in record (default: the beginning of record).	f	0	3	f	f	-1
337	46	Stop Time(seconds)	Stop Time(seconds)	Stop at the specified time. By default, rdsamp stops at the end of the record.	t	-1	3	f	f	-1
338	46	Interval limit(seconds)	Interval limit(seconds)	Limit the amount of output to the specified time interval (in standard time format; default: no limit). If both -l and -t are used, rdsamp stops at the earlier of the two limits	l	-1	3	f	f	-1
339	46	CSV Format	CSV Format	Produce output in CSV (comma-separated value) format (default: write output in tab-separated columns).	c	false	4	f	f	-1
340	46	High Res	High Res	Read the signal files in high-resolution mode (default: standard mode). These modes are identical for ordinary records. For multifrequency records, the standard decimation of oversampled signals to the frame rate is suppressed in high-resolution mode (rather, all other signals are resampled at the highest sampling frequency).	H	false	4	f	f	-1
341	46	Format output	Format output	Output times in the selected format and the values in physical units. By default, rdsamp prints times in sample intervals and values in A/D units.	format		5	f	f	-1
342	46	Signal List.	Signal List.	Print only the signals named in the signal-list (one or more input signal numbers or names, separated by spaces; default: print all signals). This option may be used to re-order or duplicate signals.	s		1	f	f	-1
343	46	Signal	Signal	Search for the first valid sample of the specified signal (a signal name or number) at or following the time specified with -f (or the beginning of the record if the -f option is not present), and begin printing at that time.	S		1	f	f	-1
344	46	Column Headings	Column Headings	Print column headings (signal names on the first line, units on the second). The names of some signals are too wide to fit in the columns; such names are shortened by omitting the initial characters (since names of related signals often differ only at the end, this helps to make the columns identifiable). Names of units are shortened when necessary by omitting the final characters, since the initial characters are usually most important for distinguishing different units. 	v	false	4	f	f	-1
345	46	XML	XML	Produce output in WFDB-XML format (same as the CSV format produced using the -c option, but wrapped within an XML header and trailer). This format is recognized and parsed automatically by wrsamp.	X	false	4	f	f	-1
346	47	Begin time (sec)	Begin time (sec)	Begin at the specified time in record (default: the beginning of record).	f	0	3	f	f	-1
347	47	End time (sec)	End time (sec)	Process until the specified time in record (default: the end of the record). 	t	-1	3	f	f	-1
348	47	High Res	High Res	Read the signal files in high-resolution mode (default: standard mode). These modes are identical for ordinary records. For multifrequency records, the standard decimation of oversampled signals to the frame rate is suppressed in high-resolution mode (rather, all other signals are resampled at the highest sampling frequency).	H	false	4	f	f	-1
349	47	annotator	annotator	Measure QRS peak-to-peak amplitudes based on normal QRS annotations from the specified annotator. Where this appears, substitute an annotator name. Annotator names are not file names! The suffix (extension) of the name of an annotation file is the annotator name for that file; so, for example, the annotator name for `e0104.atr' is `atr'. The special annotator name `atr' is used to name the set of reference annotations supplied by the database developers. Other annotation sets have annotator names that may contain letters, digits, and underscores, as for record names. 	a		1	f	f	-1
350	47	measurement window start d...	measurement window start delta	Set the measurement window start point relative to QRS annotations. Defaults: 0.05 (seconds before the annotation). 	dt1	0.05	3	f	f	-1
351	47	measurement window end del...	measurement window end delta	Set the measurement window end point relative to QRS annotations. Defaults: 0.05 (seconds after the annotation). 	dt2	0.05	3	f	f	-1
352	47	Set RMS amplitude measurem...	Set RMS amplitude measurement window.	Set RMS amplitude measurement window. Default: dtw = 1 (second)	w	1	3	f	f	-1
353	47	Measurement count	Measurement count	Make up to nmax measurements on each signal (default: 300). 	n	300	2	f	f	-1
354	47	Print results in physical ...	Print results in physical units.	Return physical units(default: ADC units) + elapsed time in seconds(same as -ps). (used with -q and -v when printing individual measurements);	p	false	4	f	f	-1
355	47	time of day and date	time of day and date	Return physical units + time of day and date if known	pd	false	4	f	f	-1
356	47	Elapsed time.	Elapsed time.	Return physical units + elapsed time as <hours>:<minutes>:<seconds>	pe	false	4	f	f	-1
357	47	Hours	Hours	Return physical units + elapsed time in hours.	ph	false	4	f	f	-1
358	47	Minutes	Minutes	Return physical units + elapsed time in minute	pm	false	4	f	f	-1
359	47	Seconds	Seconds	Return physical units + elapsed time in seconds(default, same as -p)	ps	false	4	f	f	-1
360	47	Samples	Samples	Return physical units + elapsed time in sample intervals.	pS	false	4	f	f	-1
361	47	Quick mode.	Quick mode.	Quick mode: print individual measurements only, not trimmed means.	q	false	4	f	f	-1
362	47	Verbose mode	Verbose mode	Verbose mode: print individual measurements as well as trimmed means.	v	false	4	f	f	-1
363	48	Begin time(seconds)	Begin time(seconds)	Begin at the specified time in record (default: the beginning of record).	f	0	3	f	f	-1
364	48	End time(seconds)	End time(seconds)	Process until the specified time in record (default: the end of the record). 	t	-1	3	f	f	-1
365	48	High Res	High Res	Read the signal files in high-resolution mode (default: standard mode). These modes are identical for ordinary records. For multifrequency records, the standard decimation of oversampled signals to the frame rate is suppressed in high-resolution mode (rather, all other signals are resampled at the highest sampling frequency).	H	false	4	t	f	-1
366	48	Threshold	Threshold	Specify the detection threshold (default: 500 units); use higher values to reduce false detections, or lower values to reduce the number of missed beats.	m	500	2	f	f	-1
367	48	Signal	Signal	Specify the signal (number or name) to be used for QRS detection (default: 0).	s	0	2	t	f	-1
368	52	Dump the raw	Dump the raw	Dump the raw and length-transformed input samples in text format on the standard output, but do not detect or annotate QRS complexes.	d	false	4	f	f	-1
369	52	Begin time (sec)	Begin time (sec)	Begin at the specified time in record (default: the beginning of record).	f	0	3	f	f	-1
370	52	Print a brief usage (help)...	Print a brief usage (help) summary.	Print a brief usage (help) summary.	h	false	4	f	f	-1
371	52	High Res	High Res	Read the signal files in high-resolution mode (default: standard mode). These modes are identical for ordinary records. For multifrequency records, the standard decimation of oversampled signals to the frame rate is suppressed in high-resolution mode (rather, all other signals are resampled at the highest sampling frequency).	H	false	4	t	f	-1
372	52	Annotate J-points	Annotate J-points	Find and annotate J-points (QRS ends) as well as QRS onsets.	j	false	4	f	f	-1
373	52	Threshold	Threshold	Specify the detection threshold (default: 100 microvolts); use higher values to reduce false detections, or lower values to reduce the number of missed beats.	m	100	2	f	f	-1
374	52	Power line frequency.	Power line frequency.	Specify the power line (mains) frequency used at the time of the recording, in Hz (default: 60). wqrs will apply a notch filter of the specified frequency to the input signal before length-transforming it.	p	60	2	f	f	-1
375	52	Resample the input.	Resample the input.	Resample the input at 120 Hz if the power line frequency is 60 Hz, or at 150 Hz otherwise (default: do not resample).	R	false	4	f	f	-1
376	52	Signal	Signal	Specify the signal (number or name) to be used for QRS detection (default: 0).	s	0	2	t	f	-1
377	52	End time (sec)	End time (sec)	Process until the specified time in record (default: the end of the record).	t	-1	3	f	f	-1
378	52	Verbose mode	Verbose mode	Verbose mode: print information about the detector parameters.	v	false	4	f	f	-1
\.


--
-- TOC entry 2859 (class 0 OID 36851)
-- Dependencies: 170 2873
-- Data for Name: parameterOption; Type: TABLE DATA; Schema: public; Owner: liferay
--

COPY "parameterOption" ("uiText", "uiValue", "isInitialSelection", "shortDescription", "completeDescription", parameteroptionid, "parentParameterID") FROM stdin;
\.


--
-- TOC entry 2868 (class 0 OID 37057)
-- Dependencies: 179 2873
-- Data for Name: parameterValidator; Type: TABLE DATA; Schema: public; Owner: liferay
--

COPY "parameterValidator" ("validatorType", message, min, max, regex, "parameterValidationid") FROM stdin;
0	no validator	\N	\N	\N	-1
\.


--
-- TOC entry 2882 (class 0 OID 0)
-- Dependencies: 172
-- Name: parameteroption_parameteroptionid_seq; Type: SEQUENCE SET; Schema: public; Owner: liferay
--

SELECT pg_catalog.setval('parameteroption_parameteroptionid_seq', 1, false);


--
-- TOC entry 2883 (class 0 OID 0)
-- Dependencies: 173
-- Name: parameters_parameterid_seq; Type: SEQUENCE SET; Schema: public; Owner: liferay
--

SELECT pg_catalog.setval('parameters_parameterid_seq', 7, true);


--
-- TOC entry 2884 (class 0 OID 0)
-- Dependencies: 174
-- Name: parametertype_parametertypeid_seq; Type: SEQUENCE SET; Schema: public; Owner: liferay
--

SELECT pg_catalog.setval('parametertype_parametertypeid_seq', 6, true);


--
-- TOC entry 2885 (class 0 OID 0)
-- Dependencies: 180
-- Name: parametervalidator_parametervalidationid_seq; Type: SEQUENCE SET; Schema: public; Owner: liferay
--

SELECT pg_catalog.setval('parametervalidator_parametervalidationid_seq', 1, false);


--
-- TOC entry 2886 (class 0 OID 0)
-- Dependencies: 176
-- Name: person_personid_seq; Type: SEQUENCE SET; Schema: public; Owner: liferay
--

SELECT pg_catalog.setval('person_personid_seq', 1, false);


--
-- TOC entry 2887 (class 0 OID 0)
-- Dependencies: 178
-- Name: service_serviceid_seq; Type: SEQUENCE SET; Schema: public; Owner: liferay
--

SELECT pg_catalog.setval('service_serviceid_seq', 3, true);


-- Completed on 2014-06-13 17:02:40 EDT

--
-- PostgreSQL database dump complete
--
