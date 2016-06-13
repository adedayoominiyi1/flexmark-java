package com.vladsch.flexmark.internal.util;

import com.vladsch.flexmark.node.Reference;
import com.vladsch.flexmark.parser.Parser;

import java.util.Locale;

public class ReferenceRepository extends NodeRepository<Reference> {
    public ReferenceRepository(DataHolder options) {
        super(options);
    }

    @Override
    public DataKey<ReferenceRepository> getDataKey() {
        return Parser.REFERENCES;
    }

    @Override
    public DataKey<KeepType> getKeepDataKey() {
        return Parser.REFERENCES_KEEP;
    }

    @Override
    public String normalizeKey(CharSequence key) {
        return super.normalizeKey(key).toLowerCase(Locale.ROOT);
    }
}