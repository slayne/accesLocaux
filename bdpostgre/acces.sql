--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

-- Started on 2016-06-11 21:50:07 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12403)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2195 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 190 (class 1259 OID 16611)
-- Name: acces; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE acces (
    idacces integer NOT NULL,
    idcollaborateur integer NOT NULL,
    idzone integer NOT NULL,
    heuredebut integer,
    heurefin integer,
    datedebut timestamp without time zone,
    datefin timestamp without time zone
);


ALTER TABLE acces OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16605)
-- Name: acces_idacces_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE acces_idacces_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE acces_idacces_seq OWNER TO postgres;

--
-- TOC entry 2196 (class 0 OID 0)
-- Dependencies: 187
-- Name: acces_idacces_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE acces_idacces_seq OWNED BY acces.idacces;


--
-- TOC entry 188 (class 1259 OID 16607)
-- Name: acces_idcollaborateur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE acces_idcollaborateur_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE acces_idcollaborateur_seq OWNER TO postgres;

--
-- TOC entry 2197 (class 0 OID 0)
-- Dependencies: 188
-- Name: acces_idcollaborateur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE acces_idcollaborateur_seq OWNED BY acces.idcollaborateur;


--
-- TOC entry 189 (class 1259 OID 16609)
-- Name: acces_idzone_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE acces_idzone_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE acces_idzone_seq OWNER TO postgres;

--
-- TOC entry 2198 (class 0 OID 0)
-- Dependencies: 189
-- Name: acces_idzone_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE acces_idzone_seq OWNED BY acces.idzone;


--
-- TOC entry 182 (class 1259 OID 16562)
-- Name: porte; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE porte (
    id integer NOT NULL,
    idzone integer NOT NULL,
    idzone2 integer NOT NULL
);


ALTER TABLE porte OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16579)
-- Name: porte_idZone_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "porte_idZone_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "porte_idZone_seq" OWNER TO postgres;

--
-- TOC entry 2199 (class 0 OID 0)
-- Dependencies: 185
-- Name: porte_idZone_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "porte_idZone_seq" OWNED BY porte.idzone;


--
-- TOC entry 181 (class 1259 OID 16560)
-- Name: porte_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE porte_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE porte_id_seq OWNER TO postgres;

--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 181
-- Name: porte_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE porte_id_seq OWNED BY porte.id;


--
-- TOC entry 186 (class 1259 OID 16592)
-- Name: porte_idzone2_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE porte_idzone2_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE porte_idzone2_seq OWNER TO postgres;

--
-- TOC entry 2201 (class 0 OID 0)
-- Dependencies: 186
-- Name: porte_idzone2_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE porte_idzone2_seq OWNED BY porte.idzone2;


--
-- TOC entry 184 (class 1259 OID 16570)
-- Name: zone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE zone (
    id integer NOT NULL,
    nom text
);


ALTER TABLE zone OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16568)
-- Name: zone_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE zone_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE zone_id_seq OWNER TO postgres;

--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 183
-- Name: zone_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE zone_id_seq OWNED BY zone.id;


--
-- TOC entry 2052 (class 2604 OID 16614)
-- Name: idacces; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY acces ALTER COLUMN idacces SET DEFAULT nextval('acces_idacces_seq'::regclass);


--
-- TOC entry 2053 (class 2604 OID 16615)
-- Name: idcollaborateur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY acces ALTER COLUMN idcollaborateur SET DEFAULT nextval('acces_idcollaborateur_seq'::regclass);


--
-- TOC entry 2054 (class 2604 OID 16616)
-- Name: idzone; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY acces ALTER COLUMN idzone SET DEFAULT nextval('acces_idzone_seq'::regclass);


--
-- TOC entry 2048 (class 2604 OID 16565)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY porte ALTER COLUMN id SET DEFAULT nextval('porte_id_seq'::regclass);


--
-- TOC entry 2049 (class 2604 OID 16581)
-- Name: idzone; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY porte ALTER COLUMN idzone SET DEFAULT nextval('"porte_idZone_seq"'::regclass);


--
-- TOC entry 2050 (class 2604 OID 16594)
-- Name: idzone2; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY porte ALTER COLUMN idzone2 SET DEFAULT nextval('porte_idzone2_seq'::regclass);


--
-- TOC entry 2051 (class 2604 OID 16573)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY zone ALTER COLUMN id SET DEFAULT nextval('zone_id_seq'::regclass);


--
-- TOC entry 2187 (class 0 OID 16611)
-- Dependencies: 190
-- Data for Name: acces; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY acces (idacces, idcollaborateur, idzone, heuredebut, heurefin, datedebut, datefin) FROM stdin;
\.


--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 187
-- Name: acces_idacces_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('acces_idacces_seq', 1, false);


--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 188
-- Name: acces_idcollaborateur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('acces_idcollaborateur_seq', 1, false);


--
-- TOC entry 2205 (class 0 OID 0)
-- Dependencies: 189
-- Name: acces_idzone_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('acces_idzone_seq', 1, false);


--
-- TOC entry 2179 (class 0 OID 16562)
-- Dependencies: 182
-- Data for Name: porte; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY porte (id, idzone, idzone2) FROM stdin;
1	1	2
2	2	3
3	2	4
\.


--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 185
-- Name: porte_idZone_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"porte_idZone_seq"', 1, false);


--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 181
-- Name: porte_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('porte_id_seq', 3, true);


--
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 186
-- Name: porte_idzone2_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('porte_idzone2_seq', 2, true);


--
-- TOC entry 2181 (class 0 OID 16570)
-- Dependencies: 184
-- Data for Name: zone; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY zone (id, nom) FROM stdin;
1	Accueil
2	Z2
4	Z4
3	Z3
\.


--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 183
-- Name: zone_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('zone_id_seq', 4, true);


--
-- TOC entry 2061 (class 2606 OID 16618)
-- Name: acces_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY acces
    ADD CONSTRAINT acces_pkey PRIMARY KEY (idacces);


--
-- TOC entry 2057 (class 2606 OID 16567)
-- Name: pk_porte; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY porte
    ADD CONSTRAINT pk_porte PRIMARY KEY (id);


--
-- TOC entry 2059 (class 2606 OID 16578)
-- Name: zone_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY zone
    ADD CONSTRAINT zone_pkey PRIMARY KEY (id);


--
-- TOC entry 2055 (class 1259 OID 16591)
-- Name: fki_zone; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_zone ON porte USING btree (idzone);


--
-- TOC entry 2062 (class 2606 OID 16586)
-- Name: fk_zone; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY porte
    ADD CONSTRAINT fk_zone FOREIGN KEY (idzone) REFERENCES zone(id);


--
-- TOC entry 2063 (class 2606 OID 16600)
-- Name: fk_zone2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY porte
    ADD CONSTRAINT fk_zone2 FOREIGN KEY (idzone2) REFERENCES zone(id);


--
-- TOC entry 2194 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-06-11 21:50:07 CEST

--
-- PostgreSQL database dump complete
--

