--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

-- Started on 2016-06-10 16:52:26 CEST

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
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 16562)
-- Name: porte; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE porte (
    id integer NOT NULL,
    "idZone" integer NOT NULL
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
-- TOC entry 2167 (class 0 OID 0)
-- Dependencies: 185
-- Name: porte_idZone_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "porte_idZone_seq" OWNED BY porte."idZone";


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
-- TOC entry 2168 (class 0 OID 0)
-- Dependencies: 181
-- Name: porte_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE porte_id_seq OWNED BY porte.id;


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
-- TOC entry 2169 (class 0 OID 0)
-- Dependencies: 183
-- Name: zone_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE zone_id_seq OWNED BY zone.id;


--
-- TOC entry 2036 (class 2604 OID 16565)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY porte ALTER COLUMN id SET DEFAULT nextval('porte_id_seq'::regclass);


--
-- TOC entry 2037 (class 2604 OID 16581)
-- Name: idZone; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY porte ALTER COLUMN "idZone" SET DEFAULT nextval('"porte_idZone_seq"'::regclass);


--
-- TOC entry 2038 (class 2604 OID 16573)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY zone ALTER COLUMN id SET DEFAULT nextval('zone_id_seq'::regclass);


--
-- TOC entry 2041 (class 2606 OID 16567)
-- Name: pk_porte; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY porte
    ADD CONSTRAINT pk_porte PRIMARY KEY (id);


--
-- TOC entry 2043 (class 2606 OID 16578)
-- Name: zone_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY zone
    ADD CONSTRAINT zone_pkey PRIMARY KEY (id);


--
-- TOC entry 2039 (class 1259 OID 16591)
-- Name: fki_zone; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_zone ON porte USING btree ("idZone");


--
-- TOC entry 2044 (class 2606 OID 16586)
-- Name: fk_zone; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY porte
    ADD CONSTRAINT fk_zone FOREIGN KEY ("idZone") REFERENCES zone(id);


--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-06-10 16:52:26 CEST

--
-- PostgreSQL database dump complete
--

