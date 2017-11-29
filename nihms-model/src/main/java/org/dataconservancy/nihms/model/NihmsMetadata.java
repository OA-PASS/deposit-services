/*
 * Copyright 2017 Johns Hopkins University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dataconservancy.nihms.model;

import java.net.URI;
import java.net.URL;
import java.util.List;

/**
 * Encapsulates required and optional metadata for submitting a manuscript to NIHMS.
 */
public class NihmsMetadata {

    /**
     * Journal type: electronic or print
     */
    public enum JOURNAL_PUBLICATION_TYPE {
        /**
         * print publication
         */
        ppub,

        /**
         * electronic publication
         */
        epub
    }

    /**
     * Metadata describing the manuscript
     */
    private Manuscript manuscriptMetadata;

    /**
     * Metadata describing the journal the manuscript is being published in
     */
    private Journal journalMetadata;

    /**
     * Metadata describing the people associated with the submission, and their roles
     */
    private List<Person> persons;

    /**
     * Metadata about the published article (??)
     */
    private Article articleMetadata;


    /**
     * Manuscript-related metadata fields
     */
    public class Manuscript {

        /**
         * Internal NIHMS submission ID; {@code null} unless this is a re-submission
         */
        public String nihmsId;

        /**
         * PubMed ID, if known.
         * TODO: figure out where PMID comes from, and its significance to NIHMS; difference from {@link #pubmedCentralId}
         */
        public String pubmedId;

        /**
         * PubMed Central ID, if known.
         * TODO: figure out where id comes from, and its significance to NIHMS; difference from {@link #pubmedId}
         */
        public String pubmedCentralId;

        /**
         * URL to the final version of the article, if known.
         */
        public URL manuscriptUrl;

        /**
         * DOI for the final version of the article, if known.
         */
        public URI doi;

        /**
         * {@code true} if the submission includes the the publisher's final PDF version of the manuscript
         */
        public boolean publisherPdf;

        /**
         * {@code true} if {@link #publisherPdf} is {@code true} <em>and</em> if the publisher's final PDF version should be
         * used in lieu of the NIHMS-generated PDF in PubMed Central.
         */
        public boolean showPublisherPdf;

        /**
         * The interval between a manuscript's final publication date and when the NIHMS manuscript will appear publicly in PubMed Central
         */
        public int relativeEmbargoPeriodMonths;

        public String getNihmsId() {
            return nihmsId;
        }

        public void setNihmsId(String nihmsId) {
            this.nihmsId = nihmsId;
        }

        public String getPubmedId() {
            return pubmedId;
        }

        public void setPubmedId(String pubmedId) {
            this.pubmedId = pubmedId;
        }

        public String getPubmedCentralId() {
            return pubmedCentralId;
        }

        public void setPubmedCentralId(String pubmedCentralId) {
            this.pubmedCentralId = pubmedCentralId;
        }

        public URL getManuscriptUrl() {
            return manuscriptUrl;
        }

        public void setManuscriptUrl(URL manuscriptUrl) {
            this.manuscriptUrl = manuscriptUrl;
        }

        public URI getDoi() {
            return doi;
        }

        public void setDoi(URI doi) {
            this.doi = doi;
        }

        public boolean isPublisherPdf() {
            return publisherPdf;
        }

        public void setPublisherPdf(boolean publisherPdf) {
            this.publisherPdf = publisherPdf;
        }

        public boolean isShowPublisherPdf() {
            return showPublisherPdf;
        }

        public void setShowPublisherPdf(boolean showPublisherPdf) {
            this.showPublisherPdf = showPublisherPdf;
        }

        public int getRelativeEmbargoPeriodMonths() {
            return relativeEmbargoPeriodMonths;
        }

        public void setRelativeEmbargoPeriodMonths(int relativeEmbargoPeriodMonths) {
            this.relativeEmbargoPeriodMonths = relativeEmbargoPeriodMonths;
        }
    }

    /**
     * Journal-related metadata fields
     */
    public class Journal {

        /**
         * NLM title abbreviation
         */
        public String journalId;

        /**
         * Journal type, always set to {@literal nlm-ta}
         */
        public final String journalType = "nlm-ta";

        /**
         * NLM full journal title
         */
        public String journalTitle;

        /**
         * Journal publication type
         */
        public JOURNAL_PUBLICATION_TYPE pubType;

        /**
         * Serial number for the journal
         */
        public String issn;

        public String getJournalId() {
            return journalId;
        }

        public void setJournalId(String journalId) {
            this.journalId = journalId;
        }

        public String getJournalType() {
            return journalType;
        }

        public String getJournalTitle() {
            return journalTitle;
        }

        public void setJournalTitle(String journalTitle) {
            this.journalTitle = journalTitle;
        }

        public JOURNAL_PUBLICATION_TYPE getPubType() {
            return pubType;
        }

        public void setPubType(JOURNAL_PUBLICATION_TYPE pubType) {
            this.pubType = pubType;
        }

        public String getIssn() {
            return issn;
        }

        public void setIssn(String issn) {
            this.issn = issn;
        }
    }

    // TODO: filled in by submitter or for NIHMS?
    public class Article {

    }

    /**
     * Persons associated with the submission, and their roles
     */
    public static class Person {

        public String firstName;

        public String middleName;

        public String lastName;

        public String email;

        /**
         * Principle Investigator (i.e. NIHMS "funding provider")
         */
        public boolean pi;

        /**
         * NIHMS "Reviewer"
         */
        public boolean correspondingPi;

        public boolean author;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isPi() {
            return pi;
        }

        public void setPi(boolean pi) {
            this.pi = pi;
        }

        public boolean isCorrespondingPi() {
            return correspondingPi;
        }

        public void setCorrespondingPi(boolean correspondingPi) {
            this.correspondingPi = correspondingPi;
        }

        public boolean isAuthor() {
            return author;
        }

        public void setAuthor(boolean author) {
            this.author = author;
        }
    }

    public Manuscript getManuscriptMetadata() {
        return manuscriptMetadata;
    }

    public void setManuscriptMetadata(Manuscript manuscriptMetadata) {
        this.manuscriptMetadata = manuscriptMetadata;
    }

    public Journal getJournalMetadata() {
        return journalMetadata;
    }

    public void setJournalMetadata(Journal journalMetadata) {
        this.journalMetadata = journalMetadata;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Article getArticleMetadata() {
        return articleMetadata;
    }

    public void setArticleMetadata(Article articleMetadata) {
        this.articleMetadata = articleMetadata;
    }

    @Override
    public String toString() {
        return "NihmsMetadata{" +
                "manuscriptMetadata=" + manuscriptMetadata +
                ", journalMetadata=" + journalMetadata +
                ", persons=" + persons +
                ", articleMetadata=" + articleMetadata +
                '}';
    }

}
