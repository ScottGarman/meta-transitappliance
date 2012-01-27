SUMMARY = "Web browser from Mozilla"
DESCRIPTION = "Web browser from Mozilla"
HOMEPAGE = "http://www.firefox.com"
LICENSE = "MPLv1.1 & GPLv2.0 & GPLv2.1"
LIC_FILES_CHKSUM = "file://toolkit/content/license.html;md5=f918bd029113092723060a9aefffa7c5"

DEPENDS = "libidl libnotify libxt yasm-native"
PR = "r0"

SRC_URI = "http://ftp.mozilla.org/pub/firefox/releases/${PV}/source/firefox-${PV}.source.tar.bz2 \
           file://mozconfig"

SRC_URI[md5sum] = "7cf2bd379792a9b232267c6a79680566"
SRC_URI[sha256sum] = "f852011c28b00b26803b4618b52de79c705204b2f4eadba08092a379f94babae"

S = "${WORKDIR}/mozilla-release"

inherit autotools

do_configure_prepend() {
	mv ${S}/../mozconfig ${S}/

	# Parallel make in mozilla builds is set in mozconfig
	echo mk_add_options MOZ_MAKE_FLAGS=\"${PARALLEL_MAKE}\" >> ${WORKDIR}/mozconfig
}

do_configure() {
	oe_runconf
}

# Our Mozilla build already strips binaries
INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} += "${libdir}"
