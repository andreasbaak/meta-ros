require catkin.inc


DEPENDS_virtclass-native += "catkin-runtime"

RDEPENDS_${PN}_class-native = ""
RDEPENDS_${PN} = "cmake make binutils binutils-symlinks gcc gcc-symlinks g++ g++-symlinks \
    catkin-runtime"

# The files in ${PYTHON_SITEPACKAGES_DIR} are installed by
# the catkin-runtime package. Therefore, we remove them here
# so that they are not installed.
# Moreover: the ${ros_libdir}/python2.7 is empty. We need to
# remove it, otherwise the QA error [installed-vs-shipped] will hit on us.
do_install_append() {
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}
    rmdir ${D}${ros_libdir}/python2.7
}

BBCLASSEXTEND += "native"
